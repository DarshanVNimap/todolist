package com.todoApp.dao.response;

import java.time.LocalDate;
import java.util.List;

import com.todoApp.entity.Status;
import com.todoApp.entity.Users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskResponse {
	
	private String title;
	private String description;
	private LocalDate  startDate;
	private LocalDate  endDate;
	private Users user;
	private List<Users> assignedTo;
	private Status currentStatus;
	

}
