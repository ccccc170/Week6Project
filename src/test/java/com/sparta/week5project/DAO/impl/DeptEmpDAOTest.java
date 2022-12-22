package com.sparta.week5project.DAO.impl;

import com.sparta.week5project.entities.DeptEmp;
import com.sparta.week5project.entities.Employee;
import com.sparta.week5project.mappers.DeptEmpMapper;
import com.sparta.week5project.mappers.impl.DeptEmpMapperImpl;
import com.sparta.week5project.repositories.DepartmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@EnableAutoConfiguration
public class DeptEmpDAOTest {
    @Autowired
    private DeptEmpDAO deptEmpDAO;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Test
    void testGetDepartmentSummary(){
        Integer count = deptEmpDAO.getDepartmentsSummaryCount("d005", LocalDate.of(1999,1,1), LocalDate.of(2000,1,1));
        System.out.println(count);
    }
    @Test
    void testGetAllDepartmentsSummary(){
        Map<String, Integer> departmentsSummary = new HashMap<>();
        departmentsSummary = deptEmpDAO.getSummary(LocalDate.of(1999,1,1), LocalDate.of(2000,1,1));
        departmentsSummary.entrySet().stream().forEach(a -> System.out.println(a));
    }
}
