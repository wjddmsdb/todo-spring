package com.example.todo.controller;

import com.example.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("todos", todoService.findAll());
        return "list";
    }

    @GetMapping("/todos/new")
    public String addForm() {
        return "add"; // templates/add.mustache
    }

    @PostMapping("/todos")
    public String add(@RequestParam String title) {
        todoService.save(title);
        return "redirect:/";
    }

    @PostMapping("/todos/{id}/status")
    public String changeStatus(@PathVariable Long id) {
        todoService.changeStatus(id);
        return "redirect:/";
    }

    @PostMapping("/todos/{id}/delete")
    public String delete(@PathVariable Long id) {
        todoService.delete(id);
        return "redirect:/";
    }

}
