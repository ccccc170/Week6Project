package com.sparta.week6project.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "users", schema = "employees")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "api_key", unique = true)
    private UUID apiKey;

    @Column(name = "api_expiry")
    private Date apiExpiry;

    // BASIC User, UPDATE user and ADMIN user"
    @Column(name = "role")
    private String role;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UUID getApiKey() {
        return apiKey;
    }

    public void setApiKey(UUID apiKey) {
        this.apiKey = apiKey;
    }

    public Date getApiExpiry() {
        return apiExpiry;
    }

    public void setApiExpiry(Date apiExpiry) {
        this.apiExpiry = apiExpiry;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
