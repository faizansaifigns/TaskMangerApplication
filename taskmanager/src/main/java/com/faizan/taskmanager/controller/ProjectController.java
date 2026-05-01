package com.faizan.taskmanager.controller;

import com.faizan.taskmanager.model.Project;
import com.faizan.taskmanager.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // ✅ Create Project
    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    // ✅ Get All Projects
    @GetMapping
    public List<Project> getProjects() {
        return projectService.getAllProjects();
    }
}