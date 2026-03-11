package com.example.database.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.database.dto.Request.StudentRequest;
import com.example.database.dto.Response.ApiResponse;
import com.example.database.dto.Response.StudentResponse;
import com.example.database.service.StudentService;

@RestController
@RequestMapping("/Student")
public class StudentController{
    private final StudentService studentService;

    public StudentController(StudentService studentService){
          this.studentService=studentService;
    }
     
    @PostMapping("/result")
    public ApiResponse <StudentResponse> calResults(@RequestBody StudentRequest request){
        StudentResponse response= studentService.processStudent(request);

        return new ApiResponse<StudentResponse>("success", response);
    }
    @GetMapping("/results")
     public ApiResponse <List<StudentResponse>> getAllStudentResult(){
        List<StudentResponse> results = studentService.getAllStudentresults();

        return new ApiResponse<List<StudentResponse>>("success", results);
    }



    
}