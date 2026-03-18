package com.example.Project1.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project1.Service.StudentService;
import com.example.Project1.dto.Request.StudentRequest;
import com.example.Project1.dto.Response.ApiResponse;
import com.example.Project1.dto.Response.StudentResponse;

@RestController
@RequestMapping("/Students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/calc")
    public ApiResponse getResults(@RequestBody StudentRequest request){
        StudentResponse result = studentService.calStudentResponse(request);
        return new ApiResponse(result, "success");
    }
}