package com.sparta.week5project.repositories;

import com.sparta.week5project.entities.DeptManager;
import com.sparta.week5project.entities.DeptManagerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptManagerRepository extends JpaRepository<DeptManager, DeptManagerId> {
}