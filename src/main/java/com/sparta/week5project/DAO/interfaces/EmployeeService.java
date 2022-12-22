package com.sparta.week5project.DAO.interfaces;

import com.sparta.week5project.DTO.EmployeeDTO;
import com.sparta.week5project.entities.Employee;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface EmployeeService extends DAO<EmployeeDTO>{
    List<Employee> findEmployeeByLastName(String lastname);

    void update(EmployeeDTO e,Integer id );
}
