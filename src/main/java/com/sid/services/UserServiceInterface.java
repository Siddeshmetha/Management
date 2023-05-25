package com.sid.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.sid.payload.UserDTO;

@Service
public interface UserServiceInterface {


	UserDTO createUser(UserDTO userDTO);
	UserDTO updateUser(UserDTO userDTO,Integer userId);
	UserDTO getUserById(Integer userId);
	List<UserDTO> getAllUsers();
	void deleteUser(Integer userId);
}
