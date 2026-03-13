package com.example.schoolmanagementsystem.controller;

import org.springframework.web.bind.annotation.*;
import com.example.schoolmanagementsystem.service.DepartmentService;
import com.example.schoolmanagementsystem.entity.DepartmentEntity;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service){
        this.service=service;
    }

    @PostMapping("/add")
    public DepartmentEntity addDepartment(@RequestParam String name){
        return service.addDepartment(name);
    }
}