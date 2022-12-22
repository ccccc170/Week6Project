package com.sparta.week5project.MapperImplTests;

import com.sparta.week5project.DTO.DeptManagerDTO;
import com.sparta.week5project.entities.Department;
import com.sparta.week5project.entities.DeptManager;
import com.sparta.week5project.entities.DeptManagerId;
import com.sparta.week5project.entities.Employee;
import com.sparta.week5project.mappers.impl.DeptManagerMapperImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class DeptManagerMapperImplTest {
    @Autowired
    DeptManagerMapperImpl deptManagerMapper;

    @Test
    void deptManagerToDTOTest() {
        DeptManager deptManager = new DeptManager();
        Department department = new Department();
        DeptManagerId deptManagerId = new DeptManagerId();
        Employee employee = new Employee();
        department.setDeptName("Sales");
        department.setId("id");
        deptManagerId.setDeptNo("2");
        deptManagerId.setEmpNo(1);
        employee.setId(2);
        employee.setGender("F");
        employee.setFirstName("Pauline");
        employee.setLastName("Fowler");
        employee.setHireDate(LocalDate.of(2003, 01, 01));
        employee.setBirthDate(LocalDate.of(1965, 01, 01));
        deptManager.setDeptNo(department);
        deptManager.setEmpNo(employee);
        deptManager.setId(deptManagerId);
        deptManager.setFromDate(LocalDate.of(2003, 01, 01));
        deptManager.setToDate(LocalDate.of(2007, 01, 01));

        DeptManagerDTO result = deptManagerMapper.deptManagerToDTO(deptManager);
        System.out.println(result);
        Assertions.assertEquals(deptManager.getDeptNo(), result.getDeptNo());
        Assertions.assertEquals(deptManager.getId(), result.getId());
        Assertions.assertEquals(deptManager.getEmpNo(), result.getEmpNo());
        Assertions.assertEquals(deptManager.getFromDate(), result.getFromDate());
        Assertions.assertEquals(deptManager.getToDate(), result.getToDate());
    }

    @Test
    void dtoToDeptManagerTest() {
        DeptManagerDTO deptManagerDTO = new DeptManagerDTO();
        Department department = new Department();
        DeptManagerId deptManagerId = new DeptManagerId();
        Employee employee = new Employee();
        department.setDeptName("Marketing");
        department.setId("Yup");
        deptManagerId.setDeptNo("23");
        deptManagerId.setEmpNo(12);
        employee.setId(22);
        employee.setGender("M");
        employee.setFirstName("Mark");
        employee.setLastName("Fowler");
        employee.setHireDate(LocalDate.of(2004, 01, 01));
        employee.setBirthDate(LocalDate.of(1975, 01, 01));
        deptManagerDTO.setDeptNo(department);
        deptManagerDTO.setEmpNo(employee);
        deptManagerDTO.setId(deptManagerId);
        deptManagerDTO.setFromDate(LocalDate.of(2005, 01, 01));
        deptManagerDTO.setToDate(LocalDate.of(2008, 01, 01));

        DeptManager result = deptManagerMapper.dtoToDeptManager(deptManagerDTO);
        System.out.println(result);
        Assertions.assertEquals(deptManagerDTO.getDeptNo(), result.getDeptNo());
        Assertions.assertEquals(deptManagerDTO.getId(), result.getId());
        Assertions.assertEquals(deptManagerDTO.getEmpNo(), result.getEmpNo());
        Assertions.assertEquals(deptManagerDTO.getFromDate(), result.getFromDate());
        Assertions.assertEquals(deptManagerDTO.getToDate(), result.getToDate());
    }
}
