package com.mandiri.ProjectMonitor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mandiri.ProjectMonitor.Service.RoleService;
import com.mandiri.ProjectMonitor.Service.UserService;
import com.mandiri.ProjectMonitor.exception.ErrorException;
import com.mandiri.ProjectMonitor.model.user.User;
import com.mandiri.ProjectMonitor.model.user.UserRegister;

@Controller
public class UserController implements ErrorController {
	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;

	@RequestMapping("/hello")
	public String hello() {
		return "index";
	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("userForm", new UserRegister());
		return "register";
	}

	@GetMapping("/userview")
	public String allUser(Model model) throws ErrorException {
		List<User> users = userService.findAll();
		
		model.addAttribute("users", users);
		
		return "userview";
	}

	@PostMapping(value = "/register")
	public String register(@ModelAttribute("userForm") UserRegister userRegister, BindingResult result) {
		try {
			if (result.hasErrors()) {
				System.out.println(result.toString());
				return "/register";
			}

			System.out.println(roleService.findById(userRegister.getRoleId()).getId());
			System.out.println(roleService.findById(userRegister.getRoleId()).getRoles());

			User user = new User();
			user.setName(userRegister.getName());
			user.setRole(roleService.findById(userRegister.getRoleId()));
			user.setEmail(userRegister.getEmail());
			user.setUsername(userRegister.getUsername());
			user.setPassword(userRegister.getPassword());

			saveUser(user);

			return "success";
		} catch (Exception e) {
			System.out.println(e);
			return "/error";
		}
	}
	
	@PostMapping(value = "/user/update")
	public String updateUser(@RequestBody User user) {
		try {
			System.out.println("test");
			System.out.println(user.getId());
			User us = userService.findById(user.getId()).get();
			
			System.out.println(us.getName());
			System.out.println(us.getId());
			
			String encryptedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
			user.setPassword(encryptedPassword);
			
			userService.updateUser(user);

			return "success";
		} catch (Exception e) {
			System.out.println(e);
			return "/error";
		}
	}

	@PostMapping(value = "/user/insert")
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		try {
			String encryptedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
			user.setPassword(encryptedPassword);

			System.out.println(user.getName());
			System.out.println(user.getRole());
			System.out.println(user.getEmail());
			System.out.println(user.getUsername());
			System.out.println(user.getPassword());

			userService.insertUser(user);

			return new ResponseEntity<>("User inserted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/login")
	public ResponseEntity<?> loginUser(@RequestParam String email, @RequestParam String password) {
		try {
			boolean matched = BCrypt.checkpw(password, userService.findByEmail(email).getPassword());
			User user = null;
			// User user = userService.login(email, password);
			if (matched == true) {
				user = userService.findByEmail(email);
				return new ResponseEntity<>(user, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Wrong email and/or password", HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/user/all")
	public ResponseEntity<?> allUser() {
		try {
			List<User> users = userService.findAll();

			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping("/error")
	public String handleError() {
		// do something like logging
		return "error";
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

	@RequestMapping("/success")
	public String success() {
		return "success";
	}
}