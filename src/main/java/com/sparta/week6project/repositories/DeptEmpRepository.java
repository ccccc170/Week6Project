package com.sparta.week6project.repositories;

import com.sparta.week6project.entities.DeptEmp;
import com.sparta.week6project.entities.DeptEmpId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface DeptEmpRepository extends JpaRepository<DeptEmp, DeptEmpId> {

    @Query(value = "SELECT * FROM employees.dept_emp WHERE dept_no = :departmentNumber", nativeQuery = true)
    List<DeptEmp> findAllByDeptNumberSQL(String departmentNumber);


    @Query(value = "SELECT COUNT(*) FROM dept_emp WHERE dept_no = :departmentNo AND from_date >= :fromDate AND to_date <= :toDate", nativeQuery = true)
    Optional<Integer> getDepartmentsSummary(String departmentNo, LocalDate fromDate, LocalDate toDate);

    @Query(value = "SELECT * FROM employees.dept_emp WHERE dept_no = :departmentNumber AND to_date = :givenDate", nativeQuery = true)
    List<DeptEmp> findAllByDeptNumberAndDateSQL(String departmentNumber, LocalDate givenDate);

    @Query(value = "SELECT COUNT(*) FROM dept_emp WHERE dept_no = :departmentNo AND from_date <= :givenDate AND to_date >= :givenDate", nativeQuery = true)
    Optional<Integer> findAllByDepartmentNameAndDate(String departmentNo, LocalDate givenDate);


}