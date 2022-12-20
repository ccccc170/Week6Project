package com.sparta.week5project.repositories;

import com.sparta.week5project.entities.DeptManager;
import com.sparta.week5project.entities.DeptManagerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptManagerRepository extends JpaRepository<DeptManager, DeptManagerId> {
}