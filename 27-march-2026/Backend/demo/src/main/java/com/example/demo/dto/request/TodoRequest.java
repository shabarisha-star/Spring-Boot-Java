package com.example.demo.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoRequest {

    private String title;
    private String description;
}