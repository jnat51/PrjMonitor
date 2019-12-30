package com.mandiri.ProjectMonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mandiri.ProjectMonitor.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
		@Query("From Role WHERE id = :id")
		public Role findById(@Param("id") long id);
	}