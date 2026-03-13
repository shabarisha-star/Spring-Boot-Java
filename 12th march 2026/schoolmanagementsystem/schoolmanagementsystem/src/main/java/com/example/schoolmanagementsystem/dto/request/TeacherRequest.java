package com.example.schoolmanagementsystem.dto.request;

public class TeacherRequest {

    private String name;
    private String phone;
    private Long departmentId;

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Long getDepartmentId() {
        return departmentId;
    }
}