package com.sparta.week5project.DAO.impl;

import com.sparta.week5project.DAO.interfaces.DAO;
import com.sparta.week5project.DAO.interfaces.EmployeeService;
import com.sparta.week5project.entities.Employee;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class EmployeeDAO implements EmployeeService {

    @Override
    public Employee findById(Integer id) {
        return null;
    }

    @Override
    public int save(Employee e) {
        return 0;
    }

    @Override
    public void update(Employee e) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public List<Employee> findEmployeeByLastName(String lastname) {
        return null;
    }

    @Override
    public List<Employee> findEmployeeByDepartmentAndDate(Integer deptId, LocalDate from, LocalDate to) {
        return null;
    }

    @Override
    public boolean isThereGenderPayGap() {
        return false;
    }

    @Override
    public Map<String, Double> getDifferenceInPay() {
        return null;
    }
}

