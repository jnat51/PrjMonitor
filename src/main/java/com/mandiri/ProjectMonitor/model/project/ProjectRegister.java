package com.mandiri.ProjectMonitor.model.project;

import com.mandiri.ProjectMonitor.model.Department;
import com.mandiri.ProjectMonitor.model.user.User;

public class ProjectRegister {
	private long id;
	
	private String projectCode;
	
	private String name;
	
	private String description;

	private int projectYear;

	private User user;
	
	private Department department;
	
	private String dateCreated;
	
	private String dateUpdated;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getProjectYear() {
		return projectYear;
	}

	public void setProjectYear(int projectYear) {
		this.projectYear = projectYear;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(String dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
}
