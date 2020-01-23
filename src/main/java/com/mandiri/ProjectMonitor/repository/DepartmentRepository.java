package com.mandiri.ProjectMonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mandiri.ProjectMonitor.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	@Query("FROM Department WHERE departmentCode = :departmentCode")
	Department findByDepartmentCode(@Param("departmentCode") String departmentCode);
	}