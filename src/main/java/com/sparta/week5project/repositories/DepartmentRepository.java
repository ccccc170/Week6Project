package com.sparta.week5project.repositories;

import com.sparta.week5project.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, String> {
}