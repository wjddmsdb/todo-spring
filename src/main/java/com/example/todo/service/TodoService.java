package com.example.todo.service;


import com.example.todo.Entity.Todo;
import com.example.todo.repository.TodoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public void save(String title) {
        todoRepository.save(new Todo(title));
    }

    public void changeStatus(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow();
        todo.nextStatus();
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}