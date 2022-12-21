package com.sparta.week5project.DAO.impl;

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

    public EmployeeDAO(EmployeeMapperImpl employeeMapper, EmployeeRepository employeeRepository) {
        this.employeeMapper = employeeMapper;
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDAO() {
    }

    @Override
    public Optional<EmployeeDTO> findById(Integer id) {
        return Optional.of(employeeMapper.employeeToDto(employeeRepository.findById(id).get()));
    }

    @Override
    public EmployeeDTO save(EmployeeDTO e) {
        return employeeMapper.employeeToDto(employeeRepository.save(employeeMapper.dtoToEmployee(e)));
    }


    @Override
    public void update(EmployeeDTO e) {
        e.setFirstName("INDIANA");
        e.setFirstName("JONES");
        employeeRepository.save(employeeMapper.dtoToEmployee(e));

    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
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

