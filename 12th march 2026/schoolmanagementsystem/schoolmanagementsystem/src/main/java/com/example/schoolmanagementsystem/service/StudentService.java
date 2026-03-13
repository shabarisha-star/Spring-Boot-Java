package com.example.schoolmanagementsystem.service;

import org.springframework.stereotype.Service;
import com.example.schoolmanagementsystem.repository.*;
import com.example.schoolmanagementsystem.entity.*;
import com.example.schoolmanagementsystem.dto.request.*;
import com.example.schoolmanagementsystem.dto.response.*;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;

    public StudentService(StudentRepository s,DepartmentRepository d){
        this.studentRepository=s;
        this.departmentRepository=d;
    }

    public StudentResponse addStudent(StudentRequest request){

        DepartmentEntity dept=departmentRepository.findById(request.getDepartmentId()).orElseThrow();

        StudentEntity student=new StudentEntity();
        student.setName(request.getName());
        student.setPhone(request.getPhone());
        student.setAddress(request.getAddress());
        student.setDepartment(dept);

        studentRepository.save(student);

        return new StudentResponse(student.getStudentId(),student.getName(),dept.getDepartmentName());
    }
}