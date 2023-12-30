package com.todoApp.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String email;
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "user")
	private List<UserRoleMapper> userRoleMapper;
	
	@OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
	private List<UserTaskMapper> userTaskMapper;
	
	

}
