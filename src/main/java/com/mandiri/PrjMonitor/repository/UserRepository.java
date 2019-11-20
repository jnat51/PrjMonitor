package com.mandiri.PrjMonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mandiri.PrjMonitor.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	@Query("SELECT * FROM m_user WHERE email = ?1")
	User findByEmail(String email);
	
	@Query("SELECT * FROM m_user WHERE email = :email AND password = :password")
	User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}