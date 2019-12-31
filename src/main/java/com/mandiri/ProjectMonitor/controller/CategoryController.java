package com.mandiri.ProjectMonitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mandiri.ProjectMonitor.Service.CategoryService;
import com.mandiri.ProjectMonitor.exception.ErrorException;
import com.mandiri.ProjectMonitor.model.Category;

@Controller
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@PostMapping(value = "/category/insert")
	public String insertCategory(@RequestBody Category category) throws ErrorException{
		categoryService.insertCategory(category);
		
		return "";
	}
	
	@GetMapping(value = "/category/")
	public String getAllCategory() throws ErrorException{
		categoryService.findAll();
		
		return "";
	}
}
