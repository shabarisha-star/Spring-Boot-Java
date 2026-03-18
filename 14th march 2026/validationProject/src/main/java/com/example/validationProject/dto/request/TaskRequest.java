package com.example.validationProject.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class TaskRequest {
    @NotBlank(message="Title cannot be empty")
    private String title;

    private String discription;

    @Positive(message="priority shoud be positive")
    private String priority;

}
