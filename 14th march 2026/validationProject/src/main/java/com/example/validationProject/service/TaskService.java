package com.example.validationProject.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.validationProject.dto.request.TaskRequest;
import com.example.validationProject.dto.response.TaskResponse;
import com.example.validationProject.entity.TaskEntity;
import com.example.validationProject.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

   
    public List<TaskResponse> createTask(List<TaskRequest> request) {

        List<TaskEntity> tasks = request.stream().map(req -> {
            TaskEntity task = new TaskEntity();
            task.setTitle(req.getTitle());
            task.setDiscription(req.getDiscription());
            task.setPriority(req.getPriority());
            return task;
        }).collect(Collectors.toList());

        List<TaskEntity> savedTasks = taskRepository.saveAll(tasks);

        return savedTasks.stream().map(task -> {
            TaskResponse response = new TaskResponse();
            response.setId(task.getId());
            response.setTitle(task.getTitle());
            response.setDiscription(task.getDiscription());
            response.setPriority(task.getPriority());
            return response;
        }).collect(Collectors.toList());
    }

   
    public Page<TaskEntity> getTasks(Pageable pageable) {
        return taskRepository.findAll(pageable);
    }
}