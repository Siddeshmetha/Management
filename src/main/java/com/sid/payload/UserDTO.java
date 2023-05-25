package com.sid.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.Data;

@Data
public class UserDTO {
	
	private  Integer id;
	
	@NotNull
	@Size(min=3 ,message="Name should be minimum of 3 letters long")
	private String name;
	
	@Email
	@NotEmpty(message="Enter The Valid Email address")
	private String email;
	
	@NotEmpty( message="Password Length must be min 5 characters")
	@Size(min=5,max=16)
	private String password;
	

	private RoleDto role;
	

	
	

}
