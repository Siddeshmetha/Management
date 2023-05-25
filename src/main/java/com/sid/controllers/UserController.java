package com.sid.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sid.payload.ApiResponse;
import com.sid.payload.UserDTO;
import com.sid.servicesimpl.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
		@Autowired
		private UserService userService;
		
		
		@PostMapping("/createUser")
		public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDto){
			
			UserDTO createUserDto = userService.createUser(userDto);
			
			return new ResponseEntity<>(createUserDto,HttpStatus.OK);
	}
	
	
	
	@PutMapping("/update/{userId}")
	public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO,@PathVariable Integer userId){
		UserDTO updatedUser=userService.updateUser(userDTO, userId);
		return ResponseEntity.ok(updatedUser);
	}
	
	
		
		@GetMapping("/user/{userId}")
		public ResponseEntity<UserDTO> getSingleUsers(@PathVariable Integer userId)
		{
             System.out.println(userId);
			UserDTO userById = userService.getUserById(userId);
			return ResponseEntity.ok(userById);
	}
	 
		@GetMapping("/userall")
		public ResponseEntity<List<UserDTO>> getAllUsers()
		{
			return ResponseEntity.ok(this.userService.getAllUsers());
		}
	
	
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer userId)
	{
		userService.deleteUser(userId);
		//return ResponseEntity.ok(Map.of("message","User Deleted Succesfully"));
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Succesfully",true),HttpStatus.OK);
	}
	
	
}
