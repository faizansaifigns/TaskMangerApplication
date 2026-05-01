package com.faizan.taskmanager.model;
import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")   // optional but recommended
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;
    private String role;

    // getters and setters
}