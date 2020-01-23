package com.mandiri.ProjectMonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mandiri.ProjectMonitor.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
		@Query("FROM Category WHERE category = :category")
		Category findByCategory(@Param(value = "category") String category);
	}