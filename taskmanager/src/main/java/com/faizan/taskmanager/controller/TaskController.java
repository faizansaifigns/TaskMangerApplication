package com.faizan.taskmanager.controller;

import com.faizan.taskmanager.model.Task;
import com.faizan.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // ✅ Create Task
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    // ✅ Get all tasks
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // ✅ Get tasks by user
    @GetMapping("/user/{email}")
    public List<Task> getUserTasks(@PathVariable String email) {
        return taskService.getTasksByUser(email);
    }

    // ✅ Update status
    @PutMapping("/{id}")
    public Task updateStatus(@PathVariable Long id, @RequestParam String status) {
        return taskService.updateStatus(id, status);
    }
}