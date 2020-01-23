package com.mandiri.ProjectMonitor.controller;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mandiri.ProjectMonitor.exception.ErrorException;
import com.mandiri.ProjectMonitor.model.project.Project;
import com.mandiri.ProjectMonitor.model.project.ProjectRegister;
import com.mandiri.ProjectMonitor.service.DepartmentService;
import com.mandiri.ProjectMonitor.service.ProjectService;
import com.mandiri.ProjectMonitor.service.UserService;

@RestController
public class ProjectController {
	@Autowired
	ProjectService projectService;
	@Autowired
	UserService userService;
	@Autowired
	DepartmentService departmentService;

	@GetMapping(value = "/project/{id}")
	public String findProjectById(@PathVariable long id) throws ErrorException {
		projectService.findById(id);

		return "";
	}

	@GetMapping("/projectview")
	public String allUser(Model model) throws ErrorException {
		List<Project> projects = projectService.findAll();

		model.addAttribute("projects", projects);

		return "projectview";
	}

	@GetMapping(value = "/projects/{id}")
	public ResponseEntity<?> findProject(@PathVariable long id) throws ErrorException {
		return new ResponseEntity<>(projectService.findById(id), HttpStatus.OK);
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
	public String insert(@RequestBody ProjectRegister projectRegister) {
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

			return "sukses";
		} catch (Exception e) {
			System.out.println(e);
			return "gagal";
		}
	}

	@PutMapping(value = "/project/update")
	public String updateProject(@RequestBody Project project) {
		try {
			Project prj = projectService.findById(project.getId()).get();
			project.setDateUpdated(LocalDateTime.now());

			projectService.updateProject(project);

			return "sukses";
		} catch (Exception e) {
			return "gagal";
		}
	}

	@GetMapping(value = "/project/User/{userId}")
	public String getByDepartment(@PathVariable long userId) {
		try {
			List<Project> prj = projectService.findByUser(userId);

			return "sukses";
		} catch (Exception e) {
			return "gagal";
		}
	}

	@GetMapping(value = "/project/{projectYear}/{name}/{userId}/{departmentId}")
	public ResponseEntity<?> getByParam(@PathVariable int projectYear, @PathVariable String name, @PathVariable long userId,
			@PathVariable long departmentId) {
		try {
			List<Project> prj = projectService.findWithFilter(projectYear, name, userId, departmentId);

			return new ResponseEntity<>(prj, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
