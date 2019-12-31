package com.mandiri.ProjectMonitor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_category")
public class Category{
	@Id
	@Column(name="id")
	private long id;
	
	@Column(name="category")
	private String category;
	
	@Column(name="detail")
	private String detail;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
}