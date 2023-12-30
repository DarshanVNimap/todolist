package com.todoApp.serviceImple;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoApp.dao.request.TaskRequest;
import com.todoApp.dao.response.TaskResponse;
import com.todoApp.entity.Status;
import com.todoApp.entity.Task;
import com.todoApp.entity.UserTaskMapper;
import com.todoApp.entity.Users;
import com.todoApp.repository.TaskRepostiroy;
import com.todoApp.repository.UserRepository;
import com.todoApp.repository.UserTaskMapperRepo;
import com.todoApp.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private TaskRepostiroy taskRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserTaskMapperRepo userTaskMapperRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<Task> getAllTask() {
		
		List<Task> t=taskRepo.findAll();
		
		System.err.println(t);
		
		return t;
//		return null;
	}

	@Override
	public TaskRequest addTask(TaskRequest taskRequest) {
		// TODO Auto-generated method stub
		
		Users user = userRepo.findById(taskRequest.getAssignTo()).orElse(null);
		
		Task task = mapper.map(taskRequest, Task.class);
		
//		task.setStatus(Status.TO_DO);
		
		taskRepo.save(task);
		
		
		UserTaskMapper userTaskMapper =userTaskMapperRepo.save(
				UserTaskMapper.builder().id(0).tasks(task).user(user).status(Status.TO_DO).build()
				);
		
		
		return null;
	}

	@Override
	public TaskRequest updateTask(TaskRequest taskRequest, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteTask(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
