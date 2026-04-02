package com.example.demo.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoResponse {

    private Long id;
    private String title;
    private String description;
}