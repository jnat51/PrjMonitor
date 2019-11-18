package com.mandiri.PrjMonitor.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
@Entity
@Table(name="m_project", uniqueConstraints = @UniqueConstraint(columnNames = { "project_code" }))
public class Project{
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="project_code")
	private String projectCode;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;

	@Column(name="project_year")
	private int projectYear;

	@OneToOne
	@JoinColumn(name="user_id", referencedColumnName="id")
	private User user;
	
	@OneToOne
	@JoinColumn(name="department_id", referencedColumnName="id")
	private Department department;
	
	@Column(name="date_created")
	private LocalDateTime dateCreated;
	
	@Column(name="date_updated")
	private LocalDateTime dateUpdated;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public LocalDateTime getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(LocalDateTime dateUpdated) {
		this.dateUpdated = dateUpdated;
	}	
}