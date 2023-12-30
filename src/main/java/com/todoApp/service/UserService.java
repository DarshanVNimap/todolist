package com.todoApp.service;

import java.util.List;

import com.todoApp.dao.request.UserRequest;
import com.todoApp.dao.response.UserResponse;

public interface UserService {

	public List<?> getAllUser();
	
	public UserResponse addUser(UserRequest t);
	
	public UserResponse getUserById(Integer id);
	
	public String deleteUserById(Integer id);
	
	public UserResponse updateUser(Integer id , UserRequest t);
	
}
