package com.todoApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoApp.dao.request.TaskRequest;
import com.todoApp.service.TaskService;

@RestController
@RequestMapping("/api/task")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping
	public ResponseEntity<?> getAllTask(){
		return ResponseEntity.status(HttpStatus.OK).body(taskService.getAllTask());
	}
	
	@PostMapping
	public ResponseEntity<?> addTask(@RequestBody TaskRequest taskRequest){
		return ResponseEntity.status(HttpStatus.OK).body(taskService.addTask(taskRequest));
	}
}
