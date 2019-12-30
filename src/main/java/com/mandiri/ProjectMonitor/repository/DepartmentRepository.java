package com.mandiri.ProjectMonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mandiri.ProjectMonitor.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	}