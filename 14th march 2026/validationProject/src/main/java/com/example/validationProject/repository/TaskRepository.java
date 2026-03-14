package com.example.validationProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.validationProject.entity.TaskEntity;

public interface  TaskRepository extends JpaRepository<TaskEntity, Long>{
    
}
