package com.sid.securities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sid.Exception.ResourceNotFoundException;
import com.sid.models.Users;
import com.sid.repositories.UserRepo;



@Service
public class CustomUserDetailService implements UserDetailsService {


	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Users user = this.userRepo.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("User ", " email : " + username,0));

		return user;
	}

}






