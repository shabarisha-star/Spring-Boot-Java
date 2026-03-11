package com.example.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.database.entity.Student;

public interface  StudentRepository extends JpaRepository<Student, Long>{
    
}
