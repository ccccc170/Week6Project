package com.sparta.week5project.DAO.impl;

import com.sparta.week5project.DAO.interfaces.SalaryService;
import com.sparta.week5project.DTO.DeptEmpDTO;
import com.sparta.week5project.DTO.SalaryDTO;
import com.sparta.week5project.entities.Salary;
import com.sparta.week5project.entities.SalaryId;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class SalaryDAO implements SalaryService {
    @Override
    public Optional<SalaryDTO> findById(SalaryId id) {
        return null;
    }

    @Override
    public SalaryDTO save(SalaryDTO e) {
        return null;
    }

    @Override
    public void update(SalaryDTO e) {

    }

    @Override
    public void deleteById(SalaryId id) {

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
