package com.mandiri.ProjectMonitor.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mandiri.ProjectMonitor.exception.ErrorException;
import com.mandiri.ProjectMonitor.model.itemProject.ItemProject;
import com.mandiri.ProjectMonitor.model.itemProject.ItemProjectRegister;
import com.mandiri.ProjectMonitor.service.ItemProjectService;

@Controller
public class ItemProjectController {
	@Autowired
	ItemProjectService itemProjectService;

	@RequestMapping(value = "/item/insert")
	public String insertItemProject(@RequestBody ItemProjectRegister itemProject) throws ErrorException {
		ItemProject item = new ItemProject();
		LocalDate endAct;
		LocalDate startAct;

		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		LocalDate startPlan = LocalDate.parse(itemProject.getStartPlan(), df);
		LocalDate endPlan = LocalDate.parse(itemProject.getEndPlan(), df);
		if (itemProject.getStartAct() != null) {
			startAct = LocalDate.parse(itemProject.getStartAct(), df);
			item.setStartAct(startAct);
		}
		if (itemProject.getEndAct() != null) {
			endAct = LocalDate.parse(itemProject.getEndAct(), df);
			item.setEndAct(endAct);
		}

		item.setProject(itemProject.getProject());
		item.setCategory(itemProject.getCategory());
		item.setStatus(itemProject.getStatus());
		item.setStartPlan(startPlan);
		item.setEndPlan(endPlan);

		itemProjectService.insertItemProject(item);

		return "";
	}

	@GetMapping(value = "/item/{id}")
	public String findById(@PathVariable("id") long id) {
		itemProjectService.findById(id);

		return "";
	}

	@GetMapping(value = "/item/{projectId}")
	public String findByProject(@PathVariable("projectId") long projectId) {
		itemProjectService.findByProject(projectId);

		return "";
	}

	@GetMapping(value = "/item/")
	public String findAll(@PathVariable("id") long id) {
		itemProjectService.findAll();

		return "";
	}

	@RequestMapping(value = "/item")
	public String updateItemProject(@RequestBody ItemProjectRegister itemProject) throws ErrorException {
		ItemProject item = new ItemProject();

		itemProjectService.updateItemProject(item);

		return "";
	}
}
