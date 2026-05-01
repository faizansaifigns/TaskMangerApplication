package com.faizan.taskmanager.repository;

import com.faizan.taskmanager.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}