package com.sparta.week5project.DAO.impl;

import com.sparta.week5project.DTO.DepartmentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DepartmentDAOTest {
    @Autowired
    private DepartmentDAO departmentDAO;

    @Test
    void testFindByDept_No () {
        DepartmentDTO result = departmentDAO.findByDept_No("d009").get();
        System.out.println(result);
        Assertions.assertEquals(result.getDeptName(), "Customer Service");
    }
}
