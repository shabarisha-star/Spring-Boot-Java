package com.example.validationProject.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.validationProject.dto.request.TaskRequest;
import com.example.validationProject.dto.response.ApiResponse;
import com.example.validationProject.dto.response.TaskResponse;
import com.example.validationProject.entity.TaskEntity;
import com.example.validationProject.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    
    @PostMapping("/bulk")
    public ApiResponse<List<TaskResponse>> createTasks(
            @Valid @RequestBody List<TaskRequest> request) {

        List<TaskResponse> response = taskService.createTask(request);

        return new ApiResponse<List<TaskResponse>>("success", response);
    }

 
    @GetMapping
    public ApiResponse<Page<TaskEntity>> getTasks(Pageable pageable) {

        Page<TaskEntity> response = taskService.getTasks(pageable);

        return new ApiResponse<Page<TaskEntity>>("success", response);
    }

}