package com.example.todos.controller;

import com.example.todos.dto.request.TodoRequest;
import com.example.todos.dto.response.TodoResponse;
import com.example.todos.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService service;

    @PostMapping
    public ResponseEntity<TodoResponse> createTodo(@RequestBody TodoRequest request,
            @AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(service.createTodo(request, userDetails.getUsername()));
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> getAllTodos(@AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(service.getAllTodos(userDetails.getUsername()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponse> getTodoById(@PathVariable Long id,
            @AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(service.getTodoById(id, userDetails.getUsername()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponse> updateTodo(@PathVariable Long id, @RequestBody TodoRequest request,
            @AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(service.updateTodo(id, request, userDetails.getUsername()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id,
            @AuthenticationPrincipal UserDetails userDetails) {
        service.deleteTodo(id, userDetails.getUsername());
        return ResponseEntity.ok("Todo deleted successfully");
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<TodoResponse> toggleComplete(@PathVariable Long id,
            @AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(service.toggleComplete(id, userDetails.getUsername()));
    }
}
