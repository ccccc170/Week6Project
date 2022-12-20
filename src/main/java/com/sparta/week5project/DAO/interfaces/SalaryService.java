package com.sparta.week5project.DAO.interfaces;

import com.sparta.week5project.entities.Salary;

import java.time.LocalDate;
import java.util.List;

public interface SalaryService extends DAO<Salary> {

    Double averageSalaryForDepartmentAndDate(Integer deptId, LocalDate from, LocalDate to);


    List<Double> getSalaryRangeByJobTitleAndYear(String jobTitle, Integer year);
}
