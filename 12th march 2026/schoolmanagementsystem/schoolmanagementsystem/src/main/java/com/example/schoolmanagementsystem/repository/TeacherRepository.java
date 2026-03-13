package com.example.schoolmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.schoolmanagementsystem.entity.TeacherEntity;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {
}