package com.example.Project1.Service;

import org.springframework.stereotype.Service;

import com.example.Project1.dto.Request.StudentRequest;
import com.example.Project1.dto.Response.StudentResponse;

@Service
public class StudentService {

    public StudentResponse calStudentResponse(StudentRequest req){

        int total = 0;
        total = req.getMarks1() + req.getMarks2() + req.getMarks3() + req.getMarks4() + req.getMarks5();

        double percentage = total / 5.0;

        String result = percentage >= 75 ? "Pass" : "Fail";

        return new StudentResponse(
                req.getName(),
                percentage,
                result,
                req.getRollNumber(),
                total
        );
    }
}