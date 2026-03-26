package com.example.projectSql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectSql.entity.RegisterNumberEntity;

public interface  RegisterNumberRepository extends JpaRepository<RegisterNumberEntity, Long>{
    
}
