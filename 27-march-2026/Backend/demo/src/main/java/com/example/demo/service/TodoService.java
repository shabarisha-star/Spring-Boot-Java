package com.example.demo.service;

import com.example.demo.dto.request.TodoRequest;
import com.example.demo.dto.response.TodoResponse;
import com.example.demo.entity.Todo;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repo.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // GET ALL
    public List<TodoResponse> getAllTodos() {
        return todoRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // GET BY ID
    public TodoResponse getTodoById(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));

        return mapToResponse(todo);
    }

    // CREATE
    public TodoResponse createTodo(TodoRequest request) {
        Todo todo = new Todo();
        todo.setTitle(request.getTitle());
        todo.setDescription(request.getDescription());

        Todo saved = todoRepository.save(todo);

        return mapToResponse(saved);
    }

    // UPDATE
    public TodoResponse updateTodo(Long id, TodoRequest request) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));

        todo.setTitle(request.getTitle());
        todo.setDescription(request.getDescription());

        Todo updated = todoRepository.save(todo);

        return mapToResponse(updated);
    }

  // Delete the todo by Id
     public void deleteTodo(Long id){
         todoRepository.findById(id)
         .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
          todoRepository.deleteById(id); 
        }

    // MAPPER (Entity → Response DTO)
    private TodoResponse mapToResponse(Todo todo) {
        return new TodoResponse(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription()
        );
    }
}