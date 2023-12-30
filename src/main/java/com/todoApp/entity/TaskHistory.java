package com.todoApp.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TaskHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Status status;
	private LocalDateTime updateAt;
	
	@ManyToOne()
	private UserTaskMapper userTaskMapper;
	
	
	
}
