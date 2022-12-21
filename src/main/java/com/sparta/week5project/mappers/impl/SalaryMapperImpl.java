package com.sparta.week5project.mappers.impl;

import com.sparta.week5project.DTO.SalaryDTO;
import com.sparta.week5project.entities.Salary;
import com.sparta.week5project.mappers.SalaryMapper;

public class SalaryMapperImpl implements SalaryMapper {
    @Override
    public SalaryDTO salaryToDTO(Salary salary) {
        if(salary == null){
            return null;
        }
        SalaryDTO salaryDTO = new SalaryDTO();
        salaryDTO.setId(salary.getId());
        salaryDTO.setEmpNo(salary.getEmpNo());
        salaryDTO.setSalary(salary.getSalary());
        salaryDTO.setToDate(salary.getToDate());
        return null;
    }

    @Override
    public Salary dtoToSalary(SalaryDTO salaryDTO) {
        return null;
    }
}
