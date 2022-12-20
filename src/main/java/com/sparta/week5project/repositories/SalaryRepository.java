
package com.sparta.week5project.repositories;

import com.sparta.week5project.entities.Salary;
import com.sparta.week5project.entities.SalaryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary, SalaryId> {
}