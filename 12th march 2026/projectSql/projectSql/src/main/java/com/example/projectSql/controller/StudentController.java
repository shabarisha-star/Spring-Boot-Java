package com.example.projectSql.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectSql.dto.request.RegisterRequest;
import com.example.projectSql.dto.request.StudentRequest;
import com.example.projectSql.dto.response.ApiResponse;
import com.example.projectSql.dto.response.StudentResponse;
import com.example.projectSql.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("/result")
    public StudentResponse saveStudentResponse(@RequestBody StudentRequest studentRequest){
        return studentService.saveStudentResponse(studentRequest);
    }

    @PostMapping("/{id}/register")
    public ApiResponse<StudentResponse> assignRegister(
        @PathVariable Long id,
        @RequestBody RegisterRequest registerNumber
    ){
        StudentResponse response= studentService.assignRegistration(id, registerNumber.getRegisterNumber());
        return new ApiResponse<StudentResponse>("success", response);
    }


}
