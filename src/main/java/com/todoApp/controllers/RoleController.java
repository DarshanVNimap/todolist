package com.todoApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoApp.entity.Role;
import com.todoApp.repository.RoleRepository;

@RestController
@RequestMapping("/api/role")

public class RoleController {
	
	@Autowired
	private RoleRepository roleRepository;

	@GetMapping()
	public ResponseEntity<?> getAllRoles(){
		return ResponseEntity.ok(roleRepository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<?> saveRole(@RequestBody Role role){
		return ResponseEntity.ok(roleRepository.save(role));
	}
}
