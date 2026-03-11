package com.example.database.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.database.dto.Request.StudentRequest;
import com.example.database.dto.Response.StudentResponse;
import com.example.database.entity.Student;
import com.example.database.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public StudentResponse processStudent(StudentRequest request){

        int total = request.getMarks().stream().mapToInt(Integer::intValue).sum();
        int subject = request.getMarks().size();
        double percentage = (double) total / subject;

        String result = percentage >= 75 ? "Pass" : "Fail";

        Student student = new Student();
        student.setName(request.getName());
        student.setRollNumber(request.getRollNumber());
        student.setPersentage(percentage);
        student.setResult(result);

        studentRepository.save(student);

        return new StudentResponse(
            request.getName(),
            request.getRollNumber(),
            total,
            percentage,
            result
        );

        
    }
    public List<StudentResponse> getAllStudentresults(){
            return studentRepository.findAll()
            .stream()
            .map(student -> new StudentResponse (
                student.getName(),
                student.getRollNumber(),
                student.getTotal(),
                student.getPersentage(),
                student.getResult()
            )).toList();


        }
}