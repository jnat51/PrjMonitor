package com.mandiri.PrjMonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mandiri.PrjMonitor.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	}