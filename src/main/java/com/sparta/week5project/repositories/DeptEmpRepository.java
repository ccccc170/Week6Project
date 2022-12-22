package com.sparta.week5project.repositories;

import com.sparta.week5project.DTO.DepartmentSummaryDTO;
import com.sparta.week5project.entities.DeptEmp;
import com.sparta.week5project.entities.DeptEmpId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DeptEmpRepository extends JpaRepository<DeptEmp, DeptEmpId> {

    @Query(value = "SELECT * FROM employees.dept_emp WHERE dept_no = :departmentNumber", nativeQuery = true)
    List<DeptEmp> findAllByDeptNumberSQL(String departmentNumber);

    @Query(value = "SELECT * FROM dept_emp WHERE dept_no = :departmentNo AND from_date >= :fromDate AND to_date <= :toDate", nativeQuery = true)
    List<DeptEmp> getDepartmentsSummary(String departmentNo, LocalDate fromDate, LocalDate toDate);
}