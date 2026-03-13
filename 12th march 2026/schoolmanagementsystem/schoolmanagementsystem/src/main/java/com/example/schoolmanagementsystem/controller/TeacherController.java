package com.example.schoolmanagementsystem.controller;

import org.springframework.web.bind.annotation.*;
import com.example.schoolmanagementsystem.service.TeacherService;
import com.example.schoolmanagementsystem.dto.request.TeacherRequest;
import com.example.schoolmanagementsystem.dto.response.*;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService service;

    public TeacherController(TeacherService service){
        this.service=service;
    }

    @PostMapping("/add")
    public ApiResponse<TeacherResponse> addTeacher(@RequestBody TeacherRequest request){

        TeacherResponse response=service.addTeacher(request);

        return new ApiResponse<>("success",response);
    }
}