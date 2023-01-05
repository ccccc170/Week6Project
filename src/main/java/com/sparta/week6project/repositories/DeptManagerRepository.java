package com.sparta.week6project.repositories;

import com.sparta.week6project.entities.DeptEmp;
import com.sparta.week6project.entities.DeptManager;
import com.sparta.week6project.entities.DeptManagerId;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DeptManagerRepository extends JpaRepository<DeptManager, DeptManagerId> {
    //insert into employees.dept_manager (emp_no, dept_no, from_date, to_date) values(110022, 'd002', '2023-01-05', '2025-10-02');
    @Modifying
    @Query(value = "INSERT INTO employees.dept_manager (emp_no, dept_no, from_date, to_date) VALUES (:empNo, :deptNo, :fromDate, :toDate)", nativeQuery = true)
    @Transactional
    Integer saveDeptManager(@Param("empNo") Integer empNo, @Param("deptNo") String deptNo, @Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate);
}