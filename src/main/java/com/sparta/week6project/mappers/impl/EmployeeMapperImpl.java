package com.sparta.week6project.mappers.impl;

import com.sparta.week6project.DTO.EmployeeDTO;
import com.sparta.week6project.entities.Employee;
import com.sparta.week6project.mappers.EmployeeMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

@Component
@EnableAutoConfiguration
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeDTO employeeToDto(Employee employee) {

        if (employee == null){
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setBirthDate(employee.getBirthDate());
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setGender(employee.getGender());
        employeeDTO.setHireDate(employee.getHireDate());

        return employeeDTO;

    }

    @Override
    public Employee dtoToEmployee(EmployeeDTO employeeDTO) {

        if (employeeDTO == null){
            return null;
        }

        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setBirthDate(employeeDTO.getBirthDate());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setGender(employeeDTO.getGender());
        employee.setHireDate(employeeDTO.getHireDate());

        return employee;

    }
}
