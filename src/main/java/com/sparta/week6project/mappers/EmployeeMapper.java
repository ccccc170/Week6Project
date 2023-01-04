package com.sparta.week6project.mappers;

import com.sparta.week6project.DTO.EmployeeDTO;
import com.sparta.week6project.entities.Employee;

public interface EmployeeMapper {

    EmployeeDTO employeeToDto(Employee employee);
    Employee dtoToEmployee(EmployeeDTO employeeDTO);

}
