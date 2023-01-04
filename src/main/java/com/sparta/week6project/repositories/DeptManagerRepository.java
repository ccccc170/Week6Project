package com.sparta.week6project.repositories;

import com.sparta.week6project.entities.DeptManager;
import com.sparta.week6project.entities.DeptManagerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptManagerRepository extends JpaRepository<DeptManager, DeptManagerId> {
}