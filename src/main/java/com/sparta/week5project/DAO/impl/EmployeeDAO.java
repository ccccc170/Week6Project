package com.sparta.week5project.DAO.impl;

import com.sparta.week5project.DAO.interfaces.EmployeeService;
import com.sparta.week5project.DTO.EmployeeDTO;
import com.sparta.week5project.entities.Employee;
import com.sparta.week5project.mappers.impl.EmployeeMapperImpl;
import com.sparta.week5project.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@EnableAutoConfiguration
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
    public void update(EmployeeDTO e, Integer id) {
        Optional<Employee> employeeDb = employeeRepository.findById(id);
        if(employeeDb.isPresent()) {
            Employee existingEmployee = employeeDb.get();
            existingEmployee.setFirstName(e.getFirstName());
            existingEmployee.setLastName(e.getLastName());
            existingEmployee.setGender(e.getGender());
            existingEmployee.setBirthDate(e.getBirthDate());
            existingEmployee.setHireDate(e.getHireDate());
            employeeRepository.save(existingEmployee);
        }
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findEmployeeByLastName(String lastname) {
        return employeeRepository.findAll()
                .stream()
                .filter(a->a.getLastName().equals(lastname))
                        .collect(Collectors.toList());
    }

}

