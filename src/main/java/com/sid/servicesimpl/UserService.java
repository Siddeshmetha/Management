package com.sid.servicesimpl;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sid.Exception.ResourceNotFoundException;
import com.sid.models.Users;
import com.sid.payload.UserDTO;
import com.sid.repositories.UserRepo;
import com.sid.services.UserServiceInterface;



@Service
public class UserService implements UserServiceInterface {
	
	@Autowired
	private UserRepo userRepo;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDTO createUser(UserDTO userDTO) {
		
		String encode = passwordEncoder.encode(userDTO.getPassword());
		userDTO.setPassword(encode);
		System.out.println(userDTO);
		Users user = modelMapper.map(userDTO,Users.class);
		System.out.println(user);
		Users savedUser=userRepo.save(user);
		return modelMapper.map(savedUser, UserDTO.class);
	}

	@Override
	public UserDTO updateUser(UserDTO userDto, Integer user_Id) {
		Users user = userRepo.findById(user_Id).orElseThrow(()-> new ResourceNotFoundException("User", "Id", user_Id));
		System.out.println(user);
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		UserDTO dto = modelMapper.map(user, UserDTO.class);
		return dto; 
	}


	@Override
	public UserDTO getUserById (Integer userId) {
		Users user=userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
		System.out.println(user);
		UserDTO dto = modelMapper.map(user, UserDTO.class);
		return dto;
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<Users> findAll = userRepo.findAll();
		List<UserDTO> collect = findAll.stream().map(user->modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public void deleteUser(Integer userId) {
			Users user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("Users","id",userId));
			userRepo.delete(user);	
	}
	
    

}
