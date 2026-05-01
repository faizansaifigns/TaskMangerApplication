package com.faizan.taskmanager.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "projects")
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    // 🔥 Simple for now (later we link user)
    private String createdBy;

    // getters & setters
}