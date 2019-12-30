package com.mandiri.ProjectMonitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mandiri.ProjectMonitor.Service.RoleService;
import com.mandiri.ProjectMonitor.model.Role;

@Controller
@RequestMapping(value="/role")
public class RoleController{
	@Autowired
	RoleService roleService;
	
	@PostMapping(value = "/insert")
	public ResponseEntity<?> insertRole(@RequestBody Role role) {
		try {
			roleService.insertRole(role);

			return new ResponseEntity<>("Admin inserted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getRoleById(@PathVariable long id) {
		try {
			Role role = roleService.findById(id);

			return new ResponseEntity<>(role, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}