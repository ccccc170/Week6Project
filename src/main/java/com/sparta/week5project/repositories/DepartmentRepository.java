package com.sparta.week5project.repositories;

import com.sparta.week5project.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {
    @Query(value="SELECT * FROM departments WHERE dept_no = :dept_no1", nativeQuery = true)
    Optional<Department> findByIdNumber(@Param("dept_no1") String dept_no);

    void deleteById(String id);
}