package com.todoApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todoApp.dao.response.IListUserTaskDto;
import com.todoApp.entity.Status;
import com.todoApp.entity.Task;
import com.todoApp.entity.UserTaskMapper;
import com.todoApp.entity.Users;
import com.todoApp.repository.TaskRepostiroy;
import com.todoApp.repository.UserRepository;
import com.todoApp.repository.UserTaskMapperRepo;

@RestController
@RequestMapping("/api/utmapper")
public class UserTaskMapperController {
	
	@Autowired
	private UserTaskMapperRepo utmRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private TaskRepostiroy taskRepo;
	
	@GetMapping
	public ResponseEntity<?> getAllUserTask(){
		
		List<IListUserTaskDto> getUserTask = utmRepo.getAll();
		
		return ResponseEntity.ok(getUserTask); 
	}
	
	@PostMapping
	public ResponseEntity<?> assignTaskToUser(@RequestParam(name = "userId") Integer userId , @RequestParam(name = "taskId") Integer taskId) throws Exception{
		
		Users user = userRepo.findById(userId).orElseThrow(() -> new Exception("User not exist"));
		
		Task task = taskRepo.findById(taskId).orElseThrow(() -> new Exception("task not exist"));
		
		utmRepo.save(UserTaskMapper.builder()
								   .status(Status.TO_DO)
								   .user(user)
								   .tasks(task)
								   .build());
		
		return ResponseEntity.ok("Assigned");
	}
	
	@DeleteMapping
	public ResponseEntity<?> removeTaskToUser(@RequestParam(name = "userId") Integer userId , @RequestParam(name = "taskId") Integer taskId) throws Exception{
		
		Users user = userRepo.findById(userId).orElseThrow(() -> new Exception("User not exist"));
		
		Task task = taskRepo.findById(taskId).orElseThrow(() -> new Exception("task not exist"));
		
		utmRepo.deleteByUserAndTasks(user, task);
		
		return ResponseEntity.ok("Assigned");
	}
	
	@PutMapping
	public ResponseEntity<?> updateTaskToUser(@RequestParam(name = "userId") Integer userId , @RequestParam(name = "taskId") Integer taskId) throws Exception{
		
		Users user = userRepo.findById(userId).orElseThrow(() -> new Exception("User not exist"));
		
		Task task = taskRepo.findById(taskId).orElseThrow(() -> new Exception("task not exist"));
		
		utmRepo.deleteByUserAndTasks(user, task);
		
		return ResponseEntity.ok("Assigned");
	}
	
	

}
