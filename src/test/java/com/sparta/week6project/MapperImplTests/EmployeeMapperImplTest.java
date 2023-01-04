package com.sparta.week6project.MapperImplTests;

import com.sparta.week6project.DTO.EmployeeDTO;
import com.sparta.week6project.entities.Employee;
import com.sparta.week6project.mappers.impl.EmployeeMapperImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class EmployeeMapperImplTest {
    @Autowired
    EmployeeMapperImpl employeeMapper;
    @Test
    void employeeToDtoTest() {
        Employee employee = new Employee();
        employee.setHireDate(LocalDate.of(2007,01,01));
        employee.setId(23);
        employee.setGender("M");
        employee.setBirthDate(LocalDate.of(1960, 01, 01));
        employee.setFirstName("Billy");
        employee.setLastName("Mitchell");

        EmployeeDTO result = employeeMapper.employeeToDto(employee);
        System.out.println(result);
        Assertions.assertEquals(employee.getId(), result.getId());
        Assertions.assertEquals(employee.getGender(), result.getGender());
        Assertions.assertEquals(employee.getHireDate(), result.getHireDate());
        Assertions.assertEquals(employee.getBirthDate(), result.getBirthDate());
        Assertions.assertEquals(employee.getFirstName(), result.getFirstName());
        Assertions.assertEquals(employee.getLastName(), result.getLastName());
    }

    @Test
    void dtoToEmployeeTest() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setHireDate(LocalDate.of(2008,01,01));
        employeeDTO.setId(23);
        employeeDTO.setGender("M");
        employeeDTO.setBirthDate(LocalDate.of(1975, 01, 01));
        employeeDTO.setFirstName("Ian");
        employeeDTO.setLastName("Bealle");

        Employee result = employeeMapper.dtoToEmployee(employeeDTO);
        System.out.println(result);
        Assertions.assertEquals(employeeDTO.getId(), result.getId());
        Assertions.assertEquals(employeeDTO.getGender(), result.getGender());
        Assertions.assertEquals(employeeDTO.getHireDate(), result.getHireDate());
        Assertions.assertEquals(employeeDTO.getBirthDate(), result.getBirthDate());
        Assertions.assertEquals(employeeDTO.getFirstName(), result.getFirstName());
        Assertions.assertEquals(employeeDTO.getLastName(), result.getLastName());
    }
}
