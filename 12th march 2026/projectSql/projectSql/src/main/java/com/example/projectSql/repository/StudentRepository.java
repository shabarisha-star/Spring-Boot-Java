package com.example.projectSql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectSql.entity.StudentEntity;

public interface  StudentRepository extends JpaRepository<StudentEntity, Long>{
    
}
