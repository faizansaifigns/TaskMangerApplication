package com.faizan.taskmanager.service;

import com.faizan.taskmanager.dto.DashboardResponse;
import com.faizan.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    private TaskRepository taskRepository;

    public DashboardResponse getDashboard(String email) {

        DashboardResponse response = new DashboardResponse();

        long total = taskRepository.countByAssignedTo(email);
        long completed = taskRepository.countByAssignedToAndStatus(email, "COMPLETED");
        long pending = taskRepository.countByAssignedToAndStatus(email, "PENDING");

        response.setTotalTasks(total);
        response.setCompletedTasks(completed);
        response.setPendingTasks(pending);

        return response;
    }
}