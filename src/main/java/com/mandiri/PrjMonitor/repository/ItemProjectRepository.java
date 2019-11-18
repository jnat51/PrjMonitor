package com.mandiri.PrjMonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mandiri.PrjMonitor.model.ItemProject;

public interface ItemProjectRepository extends JpaRepository<ItemProject, Long> {
	
	}