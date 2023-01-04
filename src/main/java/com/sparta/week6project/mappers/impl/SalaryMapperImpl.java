package com.sparta.week6project.mappers.impl;

import com.sparta.week6project.DTO.SalaryDTO;
import com.sparta.week6project.entities.Salary;
import com.sparta.week6project.mappers.SalaryMapper;
import org.springframework.stereotype.Component;

@Component
public class SalaryMapperImpl implements SalaryMapper {

    @Override
    public SalaryDTO salaryToDTO(Salary salary) {
        if (salary == null){
            return null;
        }
        SalaryDTO salaryDTO = new SalaryDTO();
        salaryDTO.setId(salary.getId());
        salaryDTO.setEmpNo(salary.getEmpNo());
        salaryDTO.setSalary(salary.getSalary());
        salaryDTO.setToDate(salary.getToDate());
        return salaryDTO;
    }

    @Override
    public Salary dtoToSalary(SalaryDTO salaryDTO) {
        if (salaryDTO == null){
            return null;
        }
        Salary salary = new Salary();
        salary.setId(salaryDTO.getId());
        salary.setEmpNo(salaryDTO.getEmpNo());
        salary.setSalary(salaryDTO.getSalary());
        salary.setToDate(salaryDTO.getToDate());
        return salary;
    }
}
