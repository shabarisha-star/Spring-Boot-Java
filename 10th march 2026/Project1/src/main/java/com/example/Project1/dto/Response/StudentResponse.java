package com.example.Project1.dto.Response;

public class StudentResponse {
    private String name;
    private int rollNumber;
    private int totalMarks;
    private double persentage;
    private String result;

    public StudentResponse(String name, double persentage, String result, int rollNumber, int totalMarks) {
        this.name = name;
        this.persentage = persentage;
        this.result = result;
        this.rollNumber = rollNumber;
        this.totalMarks = totalMarks;
    }

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

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public double getPersentage() {
        return persentage;
    }

    public void setPersentage(double persentage) {
        this.persentage = persentage;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

   

}
