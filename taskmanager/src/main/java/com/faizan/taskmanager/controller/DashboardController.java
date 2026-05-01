package com.faizan.taskmanager.controller;

import com.faizan.taskmanager.dto.DashboardResponse;
import com.faizan.taskmanager.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/{email}")
    public DashboardResponse getDashboard(@PathVariable String email) {
        return dashboardService.getDashboard(email);
    }
}