package com.todoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todoApp.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{

}
