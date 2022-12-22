package com.sparta.week5project.DAO.impl;

import com.sparta.week5project.entities.DeptEmp;
import com.sparta.week5project.entities.Employee;
import com.sparta.week5project.mappers.DeptEmpMapper;
import com.sparta.week5project.mappers.impl.DeptEmpMapperImpl;
import com.sparta.week5project.repositories.DepartmentRepository;
import com.sparta.week5project.repositories.DeptEmpRepository;
import com.sparta.week5project.repositories.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@SpringBootTest
@EnableAutoConfiguration
public class DeptEmpDAOTest {
    @Autowired
    private DeptEmpDAO deptEmpDAO;

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DeptEmpRepository deptEmpRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    DeptEmpMapper deptEmpMapper;

    @Test
    void setDeptEmpDAOTest(){
        DeptEmpDAO newDeptEmpDAO = new DeptEmpDAO(departmentRepository,employeeRepository,deptEmpRepository,deptEmpMapper);
        Assertions.assertNotNull(newDeptEmpDAO);
    }
    @Test
    void testGetDepartmentSummary(){
        Integer count = deptEmpDAO.getDepartmentsCount("d005", LocalDate.of(1999,1,1), LocalDate.of(2000,1,1));
        System.out.println(count);
        Assertions.assertEquals(319, count);
    }
    @Test
    void testGetAllDepartmentsSummary(){
        Map<String, Integer> departmentsSummary = new HashMap<>();
        departmentsSummary = deptEmpDAO.getSummary(LocalDate.of(1999,1,1), LocalDate.of(2000,1,1));
        departmentsSummary.entrySet().stream().forEach(a -> System.out.println(a));
        Integer result = departmentsSummary.get("Development");
        Assertions.assertEquals(319, result);
    }
    @Test
    void testEmptyConstructor(){
        DeptEmpDAO result = new DeptEmpDAO();
        Assertions.assertNotNull(result);
    }
    @Test
    void testFindAllEmployeesByGivenDate() {
        Assertions.assertEquals(13399,deptEmpDAO.FindAllEmployeesByGivenDate("d003",LocalDate.of(1999,01,01)));
    }
}
