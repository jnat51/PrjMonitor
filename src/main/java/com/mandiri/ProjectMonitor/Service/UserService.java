package com.mandiri.ProjectMonitor.Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandiri.ProjectMonitor.exception.ErrorException;
import com.mandiri.ProjectMonitor.model.user.User;
import com.mandiri.ProjectMonitor.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public void insertUser(User user) throws ErrorException {
		if(userRepository.existsById(user.getId())==true) {
			throw new ErrorException("User already exist");
		}
		if(userRepository.findByEmail(user.getEmail())!=null)
		{
			throw new ErrorException("Email already used");
		}
		userRepository.save(user);
	}
	
	public User findByEmail(String email) throws ErrorException {
		if(userRepository.findByEmail(email)==null) {
			throw new ErrorException("Wrong email and/or password");
		}
		return userRepository.findByEmail(email);
	}
	
	public List<User> findAll() throws ErrorException {
		if(userRepository.findAll().size()==0) {
			System.out.println("kosong");
			return new ArrayList<User>();
		}
		System.out.println(userRepository.findAll().size());
		return userRepository.findAll();
	}
	
}