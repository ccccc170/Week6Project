package com.sparta.week5project.DAO.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class EmployeeDAOTest {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Test
    void findByIdTest() {
        System.out.println(employeeDAO.findById(10002).get());

    }
    @Test
    void deleteByIdTest() {
        employeeDAO.deleteById(employeeDAO.findById(11001).get().getId());

    }
}