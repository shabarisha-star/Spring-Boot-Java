package com.example.schoolmanagementsystem.service;

import org.springframework.stereotype.Service;
import com.example.schoolmanagementsystem.repository.*;
import com.example.schoolmanagementsystem.entity.*;
import com.example.schoolmanagementsystem.dto.request.*;
import com.example.schoolmanagementsystem.dto.response.*;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final DepartmentRepository departmentRepository;

    public TeacherService(TeacherRepository t,DepartmentRepository d){
        this.teacherRepository=t;
        this.departmentRepository=d;
    }

    public TeacherResponse addTeacher(TeacherRequest request){

        DepartmentEntity dept=departmentRepository.findById(request.getDepartmentId()).orElseThrow();

        TeacherEntity teacher=new TeacherEntity();
        teacher.setName(request.getName());
        teacher.setPhone(request.getPhone());
        teacher.setDepartment(dept);

        teacherRepository.save(teacher);

        return new TeacherResponse(teacher.getTeacherId(),teacher.getName(),dept.getDepartmentName());
    }
}