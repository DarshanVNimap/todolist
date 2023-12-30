package com.todoApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.todoApp.dao.response.IListUserTaskDto;
import com.todoApp.entity.Task;
import com.todoApp.entity.UserTaskMapper;
import com.todoApp.entity.Users;

public interface UserTaskMapperRepo extends JpaRepository<UserTaskMapper, Integer> {
	
	@Query(value = "select u.name as Name, u.email as Email, t.title as Title,\r\n"
			+ "	 t.description as Discription , t.start_date as StartDate, t.end_date EndDate,\r\n"
			+ "	 ut.status as Status\r\n"
			+ "from users u\r\n"
			+ "join user_task_mapper ut\r\n"
			+ "ON u.id = ut.user_id \r\n"
			+ "join task t\r\n"
			+ "ON ut.task_id = t.id;",nativeQuery = true)
	public List<IListUserTaskDto> getAll();
	
	@Transactional
    public void deleteByUserAndTasks(Users user, Task tasks);

}
