package com.sparta.week5project.MapperImplTests;

import com.sparta.week5project.DTO.SalaryDTO;
import com.sparta.week5project.entities.Employee;
import com.sparta.week5project.entities.Salary;
import com.sparta.week5project.entities.SalaryId;
import com.sparta.week5project.mappers.impl.SalaryMapperImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class SalaryMapperImplTest {
    @Autowired
    SalaryMapperImpl salaryMapper;

    @Test
    void salaryToDTO() {
        Salary salary = new Salary();
        SalaryId salaryId = new SalaryId();
        Employee employee = new Employee();
        salaryId.setEmpNo(23);
        salaryId.setFromDate(LocalDate.of(2008, 01, 01));
        employee.setHireDate(LocalDate.of(2010, 01, 01));
        employee.setBirthDate(LocalDate.of(1980, 01, 01));
        employee.setGender("F");
        employee.setId(12);
        employee.setFirstName("Zoe");
        employee.setLastName("Slater");
        salary.setSalary(22000);
        salary.setToDate(LocalDate.of(2010, 01, 01));
        salary.setId(salaryId);
        salary.setEmpNo(employee);

        SalaryDTO result = salaryMapper.salaryToDTO(salary);
        System.out.println(result);
        Assertions.assertEquals(salary.getSalary(), result.getSalary());
        Assertions.assertEquals(salary.getId(), result.getId());
        Assertions.assertEquals(salary.getEmpNo(), result.getEmpNo());
        Assertions.assertEquals(salary.getToDate(), result.getToDate());
    }

    @Test
    void dtoToSalary() {
        SalaryDTO salaryDTO = new SalaryDTO();
        SalaryId salaryId = new SalaryId();
        Employee employee = new Employee();
        salaryId.setEmpNo(24);
        salaryId.setFromDate(LocalDate.of(2009, 01, 01));
        employee.setHireDate(LocalDate.of(2009, 01, 01));
        employee.setBirthDate(LocalDate.of(1975, 01, 01));
        employee.setGender("F");
        employee.setId(13);
        employee.setFirstName("Lisa");
        employee.setLastName("Fowler");
        salaryDTO.setSalary(24000);
        salaryDTO.setToDate(LocalDate.of(2012, 01, 01));
        salaryDTO.setId(salaryId);
        salaryDTO.setEmpNo(employee);

        Salary result = salaryMapper.dtoToSalary(salaryDTO);
        System.out.println(result);
        Assertions.assertEquals(salaryDTO.getSalary(), result.getSalary());
        Assertions.assertEquals(salaryDTO.getId(), result.getId());
        Assertions.assertEquals(salaryDTO.getEmpNo(), result.getEmpNo());
        Assertions.assertEquals(salaryDTO.getToDate(), result.getToDate());
    }
}
