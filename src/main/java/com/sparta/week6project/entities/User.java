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

    // "1 is a Basic User, 10 is an Update user and 100 is Admin"
    @Column(name = "role")
    private Integer role;

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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
