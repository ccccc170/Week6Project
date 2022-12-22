package com.sparta.week5project.DAO.impl;

import com.sparta.week5project.entities.DeptEmp;
import com.sparta.week5project.entities.Employee;
import com.sparta.week5project.mappers.DeptEmpMapper;
import com.sparta.week5project.mappers.impl.DeptEmpMapperImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@EnableAutoConfiguration
public class DeptEmpDAOTest {
    @Autowired
    private DeptEmpDAO deptEmpDAO;
    @Test
    void testGetDepartmentSummary(){
        List<DeptEmp> deptEmpList = deptEmpDAO.getDepartmentsSummary("d005", LocalDate.of(1999,1,1), LocalDate.of(2000,1,1));
        Employee name = deptEmpList.get(0).getEmpNo();
        System.out.println(name.getFirstName());
    }
}
