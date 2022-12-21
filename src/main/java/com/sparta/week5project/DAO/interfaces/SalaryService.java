package com.sparta.week5project.DAO.interfaces;

import com.sparta.week5project.DTO.SalaryDTO;
import com.sparta.week5project.entities.Salary;
import com.sparta.week5project.entities.SalaryId;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SalaryService<T> {


    Optional<T> findById(SalaryId id);

    SalaryDTO save(SalaryDTO e);

    void update(SalaryDTO e);

    void deleteById(SalaryId id);
    Double averageSalaryForDepartmentAndDate(Integer deptId, LocalDate from, LocalDate to);


    List<Double> getSalaryRangeByJobTitleAndYear(String jobTitle, Integer year);
}
