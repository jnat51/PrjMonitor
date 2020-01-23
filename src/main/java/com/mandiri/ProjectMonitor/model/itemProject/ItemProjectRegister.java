package com.mandiri.ProjectMonitor.model.itemProject;

import com.mandiri.ProjectMonitor.Enum.Enum.Status;
import com.mandiri.ProjectMonitor.model.Category;
import com.mandiri.ProjectMonitor.model.project.Project;

public class ItemProjectRegister{
	private long id;
	private Project project;
	private Category category;
	private Status status;
	private String startPlan;
	private String endPlan;
	private String startAct;
	private String endAct;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getStartPlan() {
		return startPlan;
	}

	public void setStartPlan(String startPlan) {
		this.startPlan = startPlan;
	}

	public String getEndPlan() {
		return endPlan;
	}

	public void setEndPlan(String endPlan) {
		this.endPlan = endPlan;
	}

	public String getStartAct() {
		return startAct;
	}

	public void setStartAct(String startAct) {
		this.startAct = startAct;
	}

	public String getEndAct() {
		return endAct;
	}

	public void setEndAct(String endAct) {
		this.endAct = endAct;
	}
	
}