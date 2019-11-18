package com.mandiri.PrjMonitor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mandiri.PrjMonitor.model.Department;
import com.mandiri.PrjMonitor.model.Project;
import com.mandiri.PrjMonitor.model.User;

public interface ProjectRepository extends JpaRepository<Project, Long> {
		List<Project> findByProjectYear(int projectYear);
	
		List<Project> findByUser(User user);
		
		List<Project> findByDepartment(Department department);
	}