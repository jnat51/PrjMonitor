package com.mandiri.PrjMonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mandiri.PrjMonitor.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	}