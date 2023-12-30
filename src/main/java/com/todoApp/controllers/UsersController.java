package com.todoApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoApp.dao.request.UserRequest;
import com.todoApp.service.UserService;

@RestController
@RequestMapping("/api/u")
public class UsersController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<?> getAllUsers(){
		return ResponseEntity.ok(userService.getAllUser());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable(name = "id") Integer id){
		return ResponseEntity.ok(userService.getUserById(id));
	}
	
	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody UserRequest user){
		return ResponseEntity.ok(userService.addUser(user));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@RequestBody UserRequest user , @PathVariable Integer id){
		return ResponseEntity.ok(userService.updateUser(id , user));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable(name = "id") Integer id){
		return ResponseEntity.ok(userService.deleteUserById(id));
	}


}
