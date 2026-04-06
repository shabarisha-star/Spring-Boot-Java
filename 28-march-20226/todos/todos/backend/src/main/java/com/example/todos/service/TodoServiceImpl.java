package com.example.todos.service;

import com.example.todos.dto.request.TodoRequest;
import com.example.todos.dto.response.TodoResponse;
import com.example.todos.entity.Todo;
import com.example.todos.entity.User;
import com.example.todos.exception.ResourceNotFoundException;
import com.example.todos.repository.TodoRepository;
import com.example.todos.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository repository;
    private final UserRepository userRepository;

    private User getUser(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + username));
    }

    private TodoResponse toResponse(Todo todo) {
        return new TodoResponse(todo.getId(), todo.getTitle(), todo.getDescription(), todo.isCompleted());
    }

    @Override
    public TodoResponse createTodo(TodoRequest request, String username) {
        Todo todo = new Todo();
        todo.setTitle(request.getTitle());
        todo.setDescription(request.getDescription());
        todo.setCompleted(false);
        todo.setUser(getUser(username));
        return toResponse(repository.save(todo));
    }

    @Override
    public List<TodoResponse> getAllTodos(String username) {
        return repository.findByUserUsername(username).stream().map(this::toResponse).toList();
    }

    @Override
    public TodoResponse getTodoById(Long id, String username) {
        Todo todo = repository.findByIdAndUserUsername(id, username)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
        return toResponse(todo);
    }

    @Override
    public TodoResponse updateTodo(Long id, TodoRequest request, String username) {
        Todo todo = repository.findByIdAndUserUsername(id, username)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
        todo.setTitle(request.getTitle());
        todo.setDescription(request.getDescription());
        return toResponse(repository.save(todo));
    }

    @Override
    public void deleteTodo(Long id, String username) {
        repository.findByIdAndUserUsername(id, username)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
        repository.deleteById(Objects.requireNonNull(id));
    }

    @Override
    public TodoResponse toggleComplete(Long id, String username) {
        Todo todo = repository.findByIdAndUserUsername(id, username)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
        todo.setCompleted(!todo.isCompleted());
        return toResponse(repository.save(todo));
    }
}
