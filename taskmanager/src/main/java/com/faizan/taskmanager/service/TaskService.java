package com.faizan.taskmanager.service;

import com.faizan.taskmanager.model.Task;
import com.faizan.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        task.setStatus("PENDING"); // default
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getTasksByUser(String email) {
        return taskRepository.findByAssignedTo(email);
    }

    public Task updateStatus(Long id, String status) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setStatus(status);
        return taskRepository.save(task);
    }
}