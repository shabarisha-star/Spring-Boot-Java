package com.example.Project1.dto.Response;

public class ApiResponse {
    private String status;
    private StudentResponse data;

    public ApiResponse(StudentResponse data, String status) {
        this.data = data;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public StudentResponse getData() {
        return data;
    }

    public void setData(StudentResponse data) {
        this.data = data;
    }


}
