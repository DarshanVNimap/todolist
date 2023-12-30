package com.todoApp.serviceImple;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoApp.dao.request.UserRequest;
import com.todoApp.dao.response.UserResponse;
import com.todoApp.entity.Users;
import com.todoApp.repository.UserRepository;
import com.todoApp.service.UserService;

@Service
public class UsersServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<?> getAllUser() {
		return userRepo.findAll()
					   .stream()
					   .map( u -> mapper.map(u, UserResponse.class))
					   .toList();
				
	}

	@Override
	public UserResponse addUser(UserRequest t) {
		
		Users user = mapper.map(t, Users.class);

		return userRepo.save(user) == null ? mapper.map(user, UserResponse.class) : null;
	}

	@Override
	public UserResponse getUserById(Integer id) {
		
		Users user = userRepo.findById(id).orElseThrow();
		
		return mapper.map(user, UserResponse.class);
	}

	@Override
	public String deleteUserById(Integer id) {
		userRepo.findById(id).orElseThrow();
		userRepo.deleteById(id);
		return "User Removed!!.....";
	}

	@Override
	public UserResponse updateUser(Integer id, UserRequest t) {
		Users user = mapper.map(t, Users.class);
		user.setId(id);
		return  userRepo.save(user) == null ? mapper.map(user, UserResponse.class) : null;
	}
	
	
}
