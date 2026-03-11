package com.example.database.dto.Response;

public class StudentResponse {
    private String name;
    private int rollNumber;
    private int total;
    private double persentage;
    private String result;
    
    public StudentResponse(String name, int rollNumber, int total, double persentage, String result) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.total = total;
        this.persentage = persentage;
        this.result = result;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
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
