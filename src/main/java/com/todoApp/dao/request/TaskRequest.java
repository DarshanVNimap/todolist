package com.todoApp.dao.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest {

	private String title;
	private String description;
	private LocalDate  startDate;
	private LocalDate  endDate;
	private Integer assignTo;
	
}
