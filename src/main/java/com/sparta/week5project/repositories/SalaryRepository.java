
package com.sparta.week5project.repositories;

import com.sparta.week5project.entities.DeptEmp;
import com.sparta.week5project.entities.Salary;
import com.sparta.week5project.entities.SalaryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SalaryRepository extends JpaRepository<Salary, SalaryId> {

    @Query(value = "SELECT * FROM salaries WHERE emp_no = :empNo AND from_date < :givenDate AND to_date > :givenDate",nativeQuery = true)
    Optional<Salary> findByEmpNoAndDateSQL(Integer empNo, LocalDate givenDate);
}