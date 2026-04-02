package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.request.TodoRequest;
import com.example.demo.dto.response.ApiResponse;
import com.example.demo.dto.response.TodoResponse;
import com.example.demo.service.TodoService;

@RestController
@RequestMapping("/todos")
@CrossOrigin(origins = "http://localhost:5173")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // GET ALL
    @GetMapping
    public ApiResponse<List<TodoResponse>> getAllTodos() {
        return new ApiResponse<>(
                true,
                "Todos fetched successfully",
                todoService.getAllTodos()
        );
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ApiResponse<TodoResponse> getTodoById(@PathVariable Long id) {
        return new ApiResponse<>(
                true,
                "Todo fetched successfully",
                todoService.getTodoById(id)
        );
    }

    // CREATE
    @PostMapping
    public ApiResponse<TodoResponse> createTodo(@RequestBody TodoRequest request) {
        return new ApiResponse<>(
                true,
                "Todo created successfully",
                todoService.createTodo(request)
        );
    }

    // UPDATE
    @PutMapping("/{id}")
    public ApiResponse<TodoResponse> updateTodo(@PathVariable Long id,
                                               @RequestBody TodoRequest request) {
        return new ApiResponse<>(
                true,
                "Todo updated successfully",
                todoService.updateTodo(id, request)
        );
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);

        return new ApiResponse<>(
                true,
                "Todo deleted successfully",
                null
        );
    }
}