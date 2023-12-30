package com.todoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todoApp.entity.Task;

public interface TaskRepostiroy extends JpaRepository<Task, Integer>{
	
//	@Query(nativeQuery = true , value = "select u.name , u.email , t.title ,\r\n"
//			+ "	 t.description , t.start_date , t.end_date,\r\n"
//			+ "	 ut.status\r\n"
//			+ "from users u\r\n"
//			+ "join user_task_mapper ut\r\n"
//			+ "ON u.id = ut.user_id \r\n"
//			+ "join task t\r\n"
//			+ "ON ut.tasks_id = t.id;")
//	public List<TaskResponse> findAllTask();

}
