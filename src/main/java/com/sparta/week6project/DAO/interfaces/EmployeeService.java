package com.sparta.week6project.DAO.interfaces;

import com.sparta.week6project.DTO.EmployeeDTO;
import com.sparta.week6project.entities.Employee;

import java.util.List;

public interface EmployeeService extends DAO<EmployeeDTO>{
    List<Employee> findEmployeeByLastName(String lastname);

    void update(EmployeeDTO e,Integer id );
}
