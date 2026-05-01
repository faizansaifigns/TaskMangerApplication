package com.faizan.taskmanager.repository;

import com.faizan.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByAssignedTo(String assignedTo);

    List<Task> findByProjectId(Long projectId);
    long countByAssignedTo(String assignedTo);

    long countByAssignedToAndStatus(String assignedTo, String status);
}