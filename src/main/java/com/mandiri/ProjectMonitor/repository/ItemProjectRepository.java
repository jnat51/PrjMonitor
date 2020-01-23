package com.mandiri.ProjectMonitor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mandiri.ProjectMonitor.model.itemProject.ItemProject;

@Repository
public interface ItemProjectRepository extends JpaRepository<ItemProject, Long> {
	@Query("FROM ItemProject WHERE project.id = :projectId")
	List<ItemProject> findByProject(@Param("projectId") long projectId);
}