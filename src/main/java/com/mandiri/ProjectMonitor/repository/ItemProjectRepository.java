package com.mandiri.ProjectMonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mandiri.ProjectMonitor.model.ItemProject;

@Repository
public interface ItemProjectRepository extends JpaRepository<ItemProject, Long> {
	
	}