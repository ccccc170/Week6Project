
package com.sparta.week5project.repositories;


import com.sparta.week5project.entities.Salary;
import com.sparta.week5project.entities.SalaryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SalaryRepository extends JpaRepository<Salary, SalaryId> {

    @Query(value = "SELECT salary FROM salaries WHERE emp_no = :empNo AND from_date < :givenDate AND to_date > :givenDate",nativeQuery = true)
    Optional<Integer> findSalaryByEmpNoAndDateSQL(Integer empNo, LocalDate givenDate);

    //from_date < '2001-01-01' AND to_date > '2000-01-01'
    @Query(value = "SELECT salary FROM salaries WHERE emp_no = :empNo AND from_date <= :givenYearEnd AND to_date >= :givenYearStart ",nativeQuery = true)
    List<Integer> findSalaryByEmpNoAndDateRange(Integer empNo, LocalDate givenYearStart, LocalDate givenYearEnd);
}