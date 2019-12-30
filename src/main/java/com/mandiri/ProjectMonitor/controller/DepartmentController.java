package com.mandiri.ProjectMonitor.controller;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mandiri.ProjectMonitor.Service.DepartmentService;
import com.mandiri.ProjectMonitor.model.Department;

@Controller
@ManagedBean(value = "test")
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;

	@RequestMapping(value = "/department/insert")
	public String insertDepartment(@RequestBody Department department) {
		departmentService.insertDepartment(department);
		
		return "index";
	}
	
	@RequestMapping(value = "/department/{id}")
	public String findById(@PathVariable long id) {
		departmentService.findById(id);
		
		return "";
	}
	
	@RequestMapping(value = "/department/")
	public String findAllDepartment() {
		departmentService.findAll();
		
		return "";
	}
}