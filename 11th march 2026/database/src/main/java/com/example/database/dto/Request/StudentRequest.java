package com.example.database.dto.Request;

import java.util.List;

public class StudentRequest {
    private String name;
    private int rollNumber;
    private List<Integer> marks;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRollNumber() {
        return rollNumber;
    }
    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }
    public List<Integer> getMarks() {
        return marks;
    }
    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }
    
    
}
