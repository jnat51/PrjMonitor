package com.mandiri.ProjectMonitor.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mandiri.ProjectMonitor.model.project.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>,JpaSpecificationExecutor<Project> {

	@Query("FROM Project WHERE projectYear = :projectYear")
	List<Project> findByProjectYear(@Param(value = "projectYear") int projectYear);
	
		@Query("FROM Project WHERE id = :userId")
		List<Project> findByUser(@Param(value = "userId")long userId);
		
		@Query("FROM Project WHERE department.id = :departmentId")
		List<Project> findByDepartment(@Param("departmentId")long departmentId);
		
		@Query("From Project WHERE projectCode = :projectCode")
		Project findByProjectCode(@Param(value = "projectCode") String projectCode);

		List<Project> findAll(Specification<Project> specification);
}