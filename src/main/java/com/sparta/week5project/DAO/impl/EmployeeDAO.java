package com.sparta.week5project.DAO.impl;

import com.sparta.week5project.DAO.interfaces.DAO;
import com.sparta.week5project.DAO.interfaces.EmployeeService;
import com.sparta.week5project.DTO.EmployeeDTO;
import com.sparta.week5project.entities.Employee;
import com.sparta.week5project.mappers.impl.EmployeeMapperImpl;
import com.sparta.week5project.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class EmployeeDAO implements EmployeeService {

    @Autowired
    private EmployeeMapperImpl employeeMapper;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Optional<EmployeeDTO> findById(Integer id) {
        return Optional.of(employeeMapper.employeeToDto(employeeRepository.findById(id).get()));
    }

    @Override
    public int save(EmployeeDTO e) {
        return 0;
    }

    @Override
    public void update(EmployeeDTO e) {

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

