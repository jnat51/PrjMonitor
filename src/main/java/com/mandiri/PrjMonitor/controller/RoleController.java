package com.mandiri.PrjMonitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mandiri.PrjMonitor.Service.RoleService;
import com.mandiri.PrjMonitor.model.Role;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
@RestController
@RequestMapping("/role")
public class RoleController{
	@Autowired
	RoleService roleService;
	
	@PostMapping(value = "/")
	public ResponseEntity<?> getAdminById(@RequestBody Role role) {
		try {
			roleService.insertRole(role);

			return new ResponseEntity<>("Admin inserted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}