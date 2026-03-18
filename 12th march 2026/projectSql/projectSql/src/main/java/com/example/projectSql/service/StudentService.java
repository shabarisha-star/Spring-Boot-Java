package com.example.projectSql.service;

import org.springframework.stereotype.Service;

import com.example.projectSql.dto.request.StudentRequest;
import com.example.projectSql.dto.response.StudentResponse;
import com.example.projectSql.entity.RegisterNumberEntity;
import com.example.projectSql.entity.StudentEntity;
import com.example.projectSql.repository.RegisterNumberRepository;
import com.example.projectSql.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final RegisterNumberRepository registerNumberRepository;
    
    public StudentService(RegisterNumberRepository registerNumberRepository,StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        this.registerNumberRepository=registerNumberRepository;
    }

    public StudentResponse saveStudentResponse(StudentRequest studentRequest) {

        StudentEntity student = new StudentEntity();
        student.setName(studentRequest.getName());

        StudentEntity savedStudent = studentRepository.save(student);

        return new StudentResponse(savedStudent.getId(), savedStudent.getName(),null);
    }

    public StudentResponse assignRegistration(Long StudentId,String registerNumber){
        StudentEntity student=studentRepository.findById(StudentId)
        .orElseThrow(() -> new RuntimeException("Student not found"));

        RegisterNumberEntity register= new RegisterNumberEntity();
        register.setRegNumber(registerNumber);
        RegisterNumberEntity savedRegister=registerNumberRepository.save(register);

        student.setRegisterNumberEntity(savedRegister);

        studentRepository.save(student);

        return new StudentResponse(student.getId(), student.getName(), register.getRegNumber());


    }
}