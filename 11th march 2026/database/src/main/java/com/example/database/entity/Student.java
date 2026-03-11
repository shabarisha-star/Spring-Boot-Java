package com.example.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int rollNumber;
    private double persentage;
    private int total;
    private String result;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
