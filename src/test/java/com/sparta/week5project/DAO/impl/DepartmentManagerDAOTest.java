package com.sparta.week5project.DAO.impl;

import com.sparta.week5project.DTO.DeptManagerDTO;
import com.sparta.week5project.entities.Department;
import com.sparta.week5project.entities.DeptManagerId;
import com.sparta.week5project.entities.Employee;
import com.sparta.week5project.mappers.impl.DeptManagerMapperImpl;
import com.sparta.week5project.repositories.DepartmentRepository;
import com.sparta.week5project.repositories.DeptManagerRepository;
import com.sparta.week5project.repositories.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
class DepartmentManagerDAOTest {

    @Autowired
    private DepartmentManagerDAO departmentManagerDAO;
    @Autowired
    private DeptManagerRepository deptManagerRepository;

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DeptManagerMapperImpl deptManagerMapper;

    @Test
    void findByIdTest() {
        DeptManagerId deptManagerId = new DeptManagerId();
        deptManagerId.setDeptNo("d009");
        deptManagerId.setEmpNo(111877);

        Optional<DeptManagerDTO> result = departmentManagerDAO.findById(deptManagerId);
        Assertions.assertTrue(result.isPresent());
    }

    @Test
    void saveTest() {
        Optional<Employee> employee = employeeRepository.findById(10001);

        DeptManagerId deptManagerId = new DeptManagerId();
    deptManagerId.setEmpNo(100000);
    deptManagerId.setDeptNo("Staff");
        Department department = new Department();
        department.setDeptName("Staff");
        department.setId("d009");
    DeptManagerDTO deptManagerDTO = new DeptManagerDTO();
    deptManagerDTO.setToDate(LocalDate.of(2022, 1,1));
    deptManagerDTO.setFromDate(LocalDate.of(1999,5,5));
    deptManagerDTO.setDeptNo(department);
    deptManagerDTO.setId(deptManagerId);
    deptManagerDTO.setEmpNo(employee.get());
    departmentManagerDAO.save(deptManagerDTO);
    Assertions.assertTrue(departmentManagerDAO.findById(deptManagerId).isPresent());
    }
    @Test
    void updateTest() {

    }

    @Test
    void deleteBYIdTest() {
    }


}