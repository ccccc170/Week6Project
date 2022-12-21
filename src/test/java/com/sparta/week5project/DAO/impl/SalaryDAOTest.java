package com.sparta.week5project.DAO.impl;

import com.sparta.week5project.DTO.SalaryDTO;
import com.sparta.week5project.entities.DeptEmp;
import com.sparta.week5project.entities.Employee;
import com.sparta.week5project.entities.Salary;
import com.sparta.week5project.entities.SalaryId;
import com.sparta.week5project.mappers.EmployeeMapper;
import com.sparta.week5project.repositories.DeptEmpRepository;
import com.sparta.week5project.repositories.SalaryRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    @Autowired
    private DeptEmpRepository deptEmpRepository;
    @Autowired
    private SalaryRepository salaryRepository;

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
    @DisplayName("Given a department name and date, get average salary")
    void averageSalaryForDepartmentAndDate() {

        String departmentNumber = "d005";
        LocalDate givenDate = LocalDate.of(2000,01,01);

        System.out.println("Getting employees from department");
        List<DeptEmp> deptEmpList = deptEmpRepository.findAllByDeptNumberSQL(departmentNumber);
        for (DeptEmp d: deptEmpList) {
            System.out.println(d.getEmpNo().getId());

        }
        List<Integer> salaryList = new ArrayList<>();

        System.out.println("\nGetting employee salaries\n");
        for (DeptEmp d: deptEmpList){
            Integer empNo = d.getEmpNo().getId();
//        for (int i = 0;i < 10;i++) { //Only the first 10
//            Integer empNo = deptEmpList.get(i).getEmpNo().getId();

            Optional<Integer> someSalary = salaryRepository.findSalaryByEmpNoAndDateSQL(empNo,givenDate);
            if (someSalary.isPresent()){
                salaryList.add(someSalary.get());
            }

        }

        System.out.println("\nCalculating average...\n");

        int total = 0;
        for (int i : salaryList) {
            total += i;
        }
        System.out.println("-------------");

        double average = total/salaryList.size();

        System.out.println(average);


    }

    @Test
    void getSalaryRangeByJobTitleAndYear() {
    }
}