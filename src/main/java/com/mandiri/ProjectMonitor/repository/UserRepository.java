package com.mandiri.ProjectMonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mandiri.ProjectMonitor.model.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	@Query("FROM User WHERE email = ?1")
	User findByEmail(String email);
	
	@Query("FROM User WHERE email = :email AND password = :password")
	User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}