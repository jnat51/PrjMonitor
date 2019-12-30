package com.mandiri.ProjectMonitor.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mandiri.ProjectMonitor.Service.ProjectService;
import com.mandiri.ProjectMonitor.exception.ErrorException;
import com.mandiri.ProjectMonitor.model.project.Project;
import com.mandiri.ProjectMonitor.model.project.ProjectRegister;

@Controller
public class ProjectController {
	@Autowired
	ProjectService projectService;

	@GetMapping(value = "/project/{id}")
	public String findProjectById(@PathVariable long id) throws ErrorException {
		projectService.findById(id);

		return "";
	}

	@PostMapping(value = "/project")
	public String insertProject(@ModelAttribute("projectForm") ProjectRegister projectRegister, BindingResult result)
			throws ErrorException, ParseException {
		try {
			Project project = new Project();
			project.setProjectCode(projectRegister.getProjectCode());
			project.setDepartment(projectRegister.getDepartment());
			project.setName(projectRegister.getName());
			project.setUser(projectRegister.getUser());
			project.setDescription(projectRegister.getDescription());
			project.setProjectYear(projectRegister.getProjectYear());

			LocalDateTime dateCreated = LocalDateTime.parse(projectRegister.getDateCreated());
			LocalDateTime dateUpdated = LocalDateTime.parse(projectRegister.getDateUpdated());

			project.setDateCreated(dateCreated);
			project.setDateUpdated(dateUpdated);

			projectService.insertProject(project);

			return "";
		} catch (Exception e) {
			return "";
		}
	}

	@PostMapping(value = "/insert/project")
	public ResponseEntity<?> insert(@RequestBody ProjectRegister projectRegister) {
		try {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

			Project project = new Project();
			project.setProjectCode(projectRegister.getProjectCode());
			project.setDepartment(projectRegister.getDepartment());
			project.setName(projectRegister.getName());
			project.setUser(projectRegister.getUser());
			project.setDescription(projectRegister.getDescription());
			project.setProjectYear(projectRegister.getProjectYear());

			System.out.println(projectRegister.getProjectCode());

			LocalDateTime dateUpdated = LocalDateTime.now();
			Project sesda = projectService.findByProjectCode(projectRegister.getProjectCode());
			if (sesda == null) {
				LocalDateTime dateCreated = LocalDateTime.now();
				project.setDateCreated(dateCreated);
			}

			project.setDateUpdated(dateUpdated);

			projectService.insertProject(project);

			return new ResponseEntity<>("sukses", HttpStatus.OK);
			// return "";
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>("Gagal", HttpStatus.INTERNAL_SERVER_ERROR);
			// return "";
		}
	}
}
