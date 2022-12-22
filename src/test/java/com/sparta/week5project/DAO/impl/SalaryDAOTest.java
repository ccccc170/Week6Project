package com.sparta.week5project.DAO.impl;

import com.sparta.week5project.DTO.SalaryDTO;
import com.sparta.week5project.entities.*;
import com.sparta.week5project.mappers.EmployeeMapper;
import com.sparta.week5project.repositories.DeptEmpRepository;
import com.sparta.week5project.repositories.SalaryRepository;
import com.sparta.week5project.repositories.TitleRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class SalaryDAOTest {

    @Autowired
    private SalaryDAO salaryDAO;
    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
    private EmployeeMapper employeeMapper;


    @Test
    void findByIdTest() {
        SalaryId salaryId = new SalaryId();
        salaryId.setEmpNo(10001);
        salaryId.setFromDate(LocalDate.of(1986,06,26));
        System.out.println(salaryDAO.findById(salaryId).get().getId().getFromDate());
    }

    @Test
    @Rollback
    void saveTest() {
        SalaryDTO salaryDTO= new SalaryDTO();
        SalaryId salaryId = new SalaryId();

        salaryId.setEmpNo(10001);
        salaryId.setFromDate(LocalDate.of(1986,06,26));

        salaryDTO.setSalary(90000);
        salaryDTO.setToDate(LocalDate.of(2020,12,15));
        salaryDTO.setId(salaryId);
        salaryDTO.setEmpNo(employeeMapper.dtoToEmployee(employeeDAO.findById(salaryId.getEmpNo()).get()));
        salaryDAO.save(salaryDTO);
    }

    @Test
    @Rollback
    void updateTest() {
        SalaryId salaryId = new SalaryId();

        salaryId.setEmpNo(10001);
        salaryId.setFromDate(LocalDate.of(1986,06,26));
        salaryDAO.update(salaryDAO.findById(salaryId).get());
    }

    @Test
    @Rollback
    void deleteByIdTest() {
        SalaryId salaryId = new SalaryId();

        salaryId.setEmpNo(10001);
        salaryId.setFromDate(LocalDate.of(2001,06,22));

        salaryDAO.deleteById(salaryId);
    }

    @Test
    @DisplayName("Given a department name and date, get average salary")
    void averageSalaryForDepartmentAndDateTest() {
        double expected = 63193.0;
        double result = salaryDAO.averageSalaryForDepartmentAndDate("d005", LocalDate.of(2000,01,01));
        Assertions.assertEquals(expected,result);
    }

    //TODO
    //Add null checks
    @Test
    @DisplayName("Given a job title and a year, display the range of salary values")
    void getSalaryRangeByJobTitleAndYearTest() {
        String expected = "103005 - 39177 = 63828";
        String result = salaryDAO.getSalaryRangeByJobTitleAndYear("Engineer",1989);
        Assertions.assertEquals(expected,result);
    }

    @Test
    @DisplayName("Quantify the gender pay gap")
    void getGenderPayGapTest(){
        String expected = "The women in d005 earn 3469.0 more!";
        String result = salaryDAO.getGenderPayGap("d005",LocalDate.of(9999,01,01));
        Assertions.assertEquals(expected, result);

    }
}