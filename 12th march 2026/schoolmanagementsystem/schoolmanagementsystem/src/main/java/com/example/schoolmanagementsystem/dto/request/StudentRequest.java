package com.example.schoolmanagementsystem.dto.request;

public class StudentRequest {

    private String name;
    private String phone;
    private String address;
    private Long departmentId;

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public Long getDepartmentId() {
        return departmentId;
    }
}