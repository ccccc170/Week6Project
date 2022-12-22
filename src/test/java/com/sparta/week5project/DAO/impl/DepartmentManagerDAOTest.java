package com.sparta.week5project.DAO.impl;

import com.sparta.week5project.DTO.DeptManagerDTO;
import com.sparta.week5project.entities.DeptManagerId;
import com.sparta.week5project.repositories.DepartmentRepository;
import com.sparta.week5project.repositories.DeptManagerRepository;
import com.sparta.week5project.repositories.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

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

    @Test
    void findByIdTest() {
        DeptManagerId deptManagerId = new DeptManagerId();
        deptManagerId.setDeptNo("d009");
        deptManagerId.setEmpNo(111877);

        Optional<DeptManagerDTO> result = departmentManagerDAO.findById(deptManagerId);
        Assertions.assertTrue(result.isPresent());
    }

    @Test
    void updateTest() {
    }

    @Test
    @Rollback
    void deleteByIdTest() {
        DeptManagerId deptManagerId = new DeptManagerId();
        deptManagerId.setEmpNo(110022);
        deptManagerId.setDeptNo("d001");
        departmentManagerDAO.deleteById(deptManagerId);
        Assertions.assertFalse(deptManagerRepository.findById(deptManagerId).isPresent());
    }
}