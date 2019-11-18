package com.mandiri.PrjMonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mandiri.PrjMonitor.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	}