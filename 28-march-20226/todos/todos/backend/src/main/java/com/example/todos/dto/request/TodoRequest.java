package com.example.todos.dto.request;

import lombok.Data;

@Data
public class TodoRequest {

    private String title;
    private String description;
    private Boolean completed;
}
