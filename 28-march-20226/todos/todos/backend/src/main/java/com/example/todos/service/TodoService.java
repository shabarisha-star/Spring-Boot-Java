package com.example.todos.service;

import java.util.List;

import com.example.todos.dto.request.TodoRequest;
import com.example.todos.dto.response.TodoResponse;

public interface TodoService {
    TodoResponse createTodo(TodoRequest request, String username);
    List<TodoResponse> getAllTodos(String username);
    TodoResponse getTodoById(Long id, String username);
    TodoResponse updateTodo(Long id, TodoRequest request, String username);
    void deleteTodo(Long id, String username);
    TodoResponse toggleComplete(Long id, String username);
}