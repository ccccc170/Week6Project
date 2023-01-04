package com.sparta.week6project.mappers.impl;

import com.sparta.week6project.DTO.SalaryDTO;
import com.sparta.week6project.entities.Salary;
import com.sparta.week6project.mappers.SalaryMapper;
import com.sparta.week6project.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalaryMapperImpl implements SalaryMapper {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public SalaryDTO salaryToDTO(Salary salary) {
        if (salary == null){
            return null;
        }
        SalaryDTO salaryDTO = new SalaryDTO();
        salaryDTO.setId(salary.getId());
        salaryDTO.setEmpNo(salary.getEmpNo().getId());
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
        salary.setEmpNo(employeeRepository.findById(salaryDTO.getEmpNo()).get());
        salary.setSalary(salaryDTO.getSalary());
        salary.setToDate(salaryDTO.getToDate());
        return salary;
    }
}
