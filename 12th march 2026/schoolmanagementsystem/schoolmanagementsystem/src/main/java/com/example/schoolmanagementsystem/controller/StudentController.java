package com.example.schoolmanagementsystem.controller;

import org.springframework.web.bind.annotation.*;
import com.example.schoolmanagementsystem.service.StudentService;
import com.example.schoolmanagementsystem.dto.request.StudentRequest;
import com.example.schoolmanagementsystem.dto.response.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service){
        this.service=service;
    }

    @PostMapping("/add")
    public ApiResponse<StudentResponse> addStudent(@RequestBody StudentRequest request){

        StudentResponse response=service.addStudent(request);

        return new ApiResponse<>("success",response);
    }
}