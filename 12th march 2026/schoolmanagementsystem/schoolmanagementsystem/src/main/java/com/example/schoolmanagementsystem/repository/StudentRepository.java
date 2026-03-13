package com.example.schoolmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.schoolmanagementsystem.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}