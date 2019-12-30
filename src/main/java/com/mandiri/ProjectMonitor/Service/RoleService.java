package com.mandiri.ProjectMonitor.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandiri.ProjectMonitor.model.Role;
import com.mandiri.ProjectMonitor.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	RoleRepository roleRepository;
	
	@Transactional
	public void insertRole(Role role) {
		roleRepository.save(role);
	}
	
	public List<Role> getAllUser(){
		return roleRepository.findAll();
	}
	
	public Role findById(long id) {
		return roleRepository.findById(id);
	}
}