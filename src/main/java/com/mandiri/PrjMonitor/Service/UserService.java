package com.mandiri.PrjMonitor.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandiri.PrjMonitor.model.User;
import com.mandiri.PrjMonitor.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public void insertUser(User user) {
		userRepository.save(user);
	}
	
	public User login(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}
	
}