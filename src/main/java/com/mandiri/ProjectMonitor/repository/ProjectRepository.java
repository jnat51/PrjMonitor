package com.mandiri.ProjectMonitor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mandiri.ProjectMonitor.model.Department;
import com.mandiri.ProjectMonitor.model.project.Project;
import com.mandiri.ProjectMonitor.model.user.User;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
		List<Project> findByProjectYear(int projectYear);
	
		List<Project> findByUser(User user);
		
		List<Project> findByDepartment(Department department);
		
		@Query("From Project WHERE projectCode = :projectCode")
		Project findByProjectCode(@Param(value = "projectCode") String projectCode);
	}