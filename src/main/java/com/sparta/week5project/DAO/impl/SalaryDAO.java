package com.sparta.week5project.DAO.impl;

import com.sparta.week5project.DAO.interfaces.SalaryService;
import com.sparta.week5project.entities.Salary;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class SalaryDAO implements SalaryService {
    @Override
    public Optional<Salary> findById(Integer id) {
        return null;
    }

    @Override
    public int save(Salary e) {
        return 0;
    }

    @Override
    public void update(Salary e) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Double averageSalaryForDepartmentAndDate(Integer deptId, LocalDate from, LocalDate to) {
        return null;
    }

    @Override
    public List<Double> getSalaryRangeByJobTitleAndYear(String jobTitle, Integer year) {
        return null;
    }
}
