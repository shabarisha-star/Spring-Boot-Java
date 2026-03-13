package com.example.schoolmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.schoolmanagementsystem.entity.DepartmentEntity;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
}