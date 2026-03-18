package com.example.schoolmanagementsystem.service;

import org.springframework.stereotype.Service;
import com.example.schoolmanagementsystem.repository.DepartmentRepository;
import com.example.schoolmanagementsystem.entity.DepartmentEntity;

@Service
public class DepartmentService {

    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository){
        this.repository=repository;
    }

    public DepartmentEntity addDepartment(String name){
        DepartmentEntity d=new DepartmentEntity();
        d.setDepartmentName(name);
        return repository.save(d);
    }
}