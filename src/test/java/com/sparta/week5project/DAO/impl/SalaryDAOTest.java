package com.sparta.week5project.DAO.impl;

import com.sparta.week5project.DTO.SalaryDTO;
import com.sparta.week5project.entities.Employee;
import com.sparta.week5project.entities.SalaryId;
import com.sparta.week5project.mappers.EmployeeMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.time.LocalDate;

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
    void findById() {
        SalaryId salaryId = new SalaryId();
        salaryId.setEmpNo(10001);
        salaryId.setFromDate(LocalDate.of(1986,06,26));
        System.out.println(salaryDAO.findById(salaryId).get().getId().getFromDate());
    }

    @Test
    @Commit
    void save() {
        SalaryDTO salaryDTO= new SalaryDTO();
        SalaryId salaryId = new SalaryId();
//        Employee employee = new Employee();
//        employee.setId(9999999);
//        employee.setBirthDate(LocalDate.of(2000,07,26));
//        employee.setFirstName("Cameron");
//        employee.setLastName("Higgins");
//        employee.setGender("M");
//        employee.setHireDate(LocalDate.of(2019,2,10));

        salaryId.setEmpNo(10001);
        salaryId.setFromDate(LocalDate.of(2000,06,26));

        salaryDTO.setSalary(90000);
        salaryDTO.setToDate(LocalDate.of(2020,12,15));
        salaryDTO.setId(salaryId);
        salaryDTO.setEmpNo(employeeMapper.dtoToEmployee(employeeDAO.findById(salaryId.getEmpNo()).get()));
        salaryDAO.save(salaryDTO);
    }

    @Test
    @Commit
    void update() {
        SalaryDTO salaryDTO= new SalaryDTO();
        SalaryId salaryId = new SalaryId();

        salaryId.setEmpNo(10001);
        salaryId.setFromDate(LocalDate.of(1986,06,26));
        salaryDAO.update(salaryDAO.findById(salaryId).get());
    }

    @Test
    void deleteById() {
        SalaryId salaryId = new SalaryId();

        salaryId.setEmpNo(10001);
        salaryId.setFromDate(LocalDate.of(2000,06,26));

        salaryDAO.deleteById(salaryId);
    }

    @Test
    void averageSalaryForDepartmentAndDate() {
    }

    @Test
    void getSalaryRangeByJobTitleAndYear() {
    }
}