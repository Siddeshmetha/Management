package com.sid.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sid.models.Users;

public interface UserRepo extends JpaRepository<Users,Integer> {
	
	
     Optional<Users> findByEmail(String email);
     
}
