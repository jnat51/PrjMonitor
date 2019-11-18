package com.mandiri.PrjMonitor.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandiri.PrjMonitor.model.Role;
import com.mandiri.PrjMonitor.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	RoleRepository roleRepository;
	
	@Transactional
	public void insertRole(Role role) {
		roleRepository.save(role);
	}
	
}