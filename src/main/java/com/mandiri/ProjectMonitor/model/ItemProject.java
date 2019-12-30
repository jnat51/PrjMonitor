package com.mandiri.ProjectMonitor.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.mandiri.ProjectMonitor.Enum.Enum.Status;
import com.mandiri.ProjectMonitor.model.project.Project;

@Entity
@Table(name="item_project", uniqueConstraints = @UniqueConstraint(columnNames = { "project_id","category_id"}))
public class ItemProject{
	@Id
	@Column(name="id")
	private int id;
	
	@OneToOne
	@JoinColumn(name="project_id", referencedColumnName="id")
	private Project project;
	
	@OneToOne
	@JoinColumn(name="category_id", referencedColumnName="id")
	private Category category;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private Status status;
	
	@Column(name="start_plan")
	private LocalDate startPlan;

	@Column(name="end_plan")
	private LocalDate endPlan;

	@Column(name="start_act")
	private LocalDate startAct;

	@Column(name="end_act")
	private LocalDate endAct;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDate getStartPlan() {
		return startPlan;
	}

	public void setStartPlan(LocalDate startPlan) {
		this.startPlan = startPlan;
	}

	public LocalDate getEndPlan() {
		return endPlan;
	}

	public void setEndPlan(LocalDate endPlan) {
		this.endPlan = endPlan;
	}

	public LocalDate getStartAct() {
		return startAct;
	}

	public void setStartAct(LocalDate startAct) {
		this.startAct = startAct;
	}

	public LocalDate getEndAct() {
		return endAct;
	}

	public void setEndAct(LocalDate endAct) {
		this.endAct = endAct;
	}
	
}