package com.sparta.week6project.MapperImplTests;

import com.sparta.week6project.DTO.DeptEmpDTO;
import com.sparta.week6project.entities.Department;
import com.sparta.week6project.entities.DeptEmp;
import com.sparta.week6project.entities.DeptEmpId;
import com.sparta.week6project.entities.Employee;
import com.sparta.week6project.mappers.DeptEmpMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class DeptEmpMapperImplTest {
    @Autowired
    DeptEmpMapper deptEmpMapper;

    @Test
    void dtoToDeptEmpTest() {
        DeptEmpDTO deptEmpDTO = new DeptEmpDTO();
        DeptEmpId id = new DeptEmpId();
        Employee employee = new Employee();
        Department department = new Department();
        id.setDeptNo("num");
        id.setEmpNo(1);
        employee.setId(2);
        employee.setGender("M");
        employee.setFirstName("Phil");
        employee.setLastName("Mitchell");
        employee.setBirthDate(LocalDate.of(1964, 01, 01));
        employee.setHireDate(LocalDate.of(2000,01 ,01));
        department.setDeptName("Sales");
        department.setId("id");
        deptEmpDTO.setId(id);
        deptEmpDTO.setToDate(LocalDate.of(2002, 01, 01));
        deptEmpDTO.setFromDate(LocalDate.of(2000, 01, 01));
        deptEmpDTO.setEmpNo(employee);
        deptEmpDTO.setDeptNo(department);

        DeptEmp result = deptEmpMapper.dtoToDeptEmp(deptEmpDTO);
        System.out.println(result);
        Assertions.assertEquals(deptEmpDTO.getId(), result.getId());
        Assertions.assertEquals(deptEmpDTO.getDeptNo(), result.getDeptNo());
        Assertions.assertEquals(deptEmpDTO.getEmpNo(), result.getEmpNo());
        Assertions.assertEquals(deptEmpDTO.getToDate(), result.getToDate());
        Assertions.assertEquals(deptEmpDTO.getFromDate(), result.getFromDate());
    }

    @Test
    void deptEmpToDTOTest() {
        DeptEmp deptEmp = new DeptEmp();
        DeptEmpId id = new DeptEmpId();
        Employee employee = new Employee();
        Department department = new Department();
        id.setDeptNo("two");
        id.setEmpNo(12);
        employee.setId(23);
        employee.setGender("F");
        employee.setFirstName("Kat");
        employee.setLastName("Slater");
        employee.setBirthDate(LocalDate.of(1977, 01, 01));
        employee.setHireDate(LocalDate.of(2002,01 ,01));
        department.setDeptName("marketing");
        department.setId("yes");
        deptEmp.setId(id);
        deptEmp.setToDate(LocalDate.of(2005, 01, 01));
        deptEmp.setFromDate(LocalDate.of(2001, 01, 01));
        deptEmp.setEmpNo(employee);
        deptEmp.setDeptNo(department);

        DeptEmpDTO result = deptEmpMapper.deptEmpToDTO(deptEmp);
        System.out.println(result);
        Assertions.assertEquals(deptEmp.getId(), result.getId());
        Assertions.assertEquals(deptEmp.getDeptNo(), result.getDeptNo());
        Assertions.assertEquals(deptEmp.getEmpNo(), result.getEmpNo());
        Assertions.assertEquals(deptEmp.getToDate(), result.getToDate());
        Assertions.assertEquals(deptEmp.getFromDate(), result.getFromDate());
    }
}
