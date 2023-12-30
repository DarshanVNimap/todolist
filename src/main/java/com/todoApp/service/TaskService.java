package com.todoApp.service;

import java.util.List;

import com.todoApp.dao.request.TaskRequest;

public interface TaskService {
	
	public List<?> getAllTask();
	
	public TaskRequest addTask(TaskRequest taskRequest);
	
	public TaskRequest updateTask(TaskRequest taskRequest , Integer id);
	
	public String deleteTask(Integer id);

}
