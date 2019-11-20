package com.mandiri.PrjMonitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mandiri.PrjMonitor.Service.UserService;
import com.mandiri.PrjMonitor.model.User;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
@RestController
@RequestMapping("/user")
public class UserController{
	@Autowired
	UserService userService;
	
	@PostMapping(value = "/")
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		try {
			userService.insertUser(user);

			return new ResponseEntity<>("User inserted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/login")
	public ResponseEntity<?> loginUser(@RequestParam String email, @RequestParam String password) {
		try {
			User user = userService.login(email, password);

			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}