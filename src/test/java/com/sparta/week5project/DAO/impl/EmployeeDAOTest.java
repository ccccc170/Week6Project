package com.sparta.week5project.DAO.impl;

import com.sparta.week5project.DTO.EmployeeDTO;
import com.sparta.week5project.entities.Employee;
import com.sparta.week5project.mappers.impl.EmployeeMapperImpl;
import com.sparta.week5project.repositories.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@SpringBootTest
class EmployeeDAOTest {

    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapperImpl employeeMapper;

    @Test
    void findByIdTest() {
        System.out.println(employeeDAO.findById(10002).get());
        Optional<EmployeeDTO> employee = employeeDAO.findById(10002);
        Assertions.assertTrue(employee.isPresent());

    }

    @Test
    void testSaveMethod() {
        Employee employee1 = new Employee();
        employee1.setFirstName("John");
        employee1.setLastName("Johnson");
        employee1.setGender("M");
        employee1.setBirthDate(LocalDate.of(1999,1,1));
        employee1.setHireDate(LocalDate.of(2020,1,1));
        employee1.setId(10);
        Optional<Employee> employee = employeeRepository.findById(10);
        if (employee.isEmpty()) {
            employeeDAO.save(employeeMapper.employeeToDto(employee1));
        }
        Assertions.assertTrue(employeeDAO.findById(10).get().getFirstName().equals("John"));
    }

    @Test
    void testUpdateMethod() {
        Optional<Employee> employee = employeeRepository.findById(10008);
        if (employee.isPresent()) {
            Employee employee1 = new Employee();
            employee1.setFirstName("John");
            employee1.setLastName("Johnson");
            employee1.setGender("M");
            employee1.setBirthDate(LocalDate.of(1999,1,1));
            employee1.setHireDate(LocalDate.of(2020,1,1));
            employeeDAO.update(employeeMapper.employeeToDto(employee1), 10008);
        }
        Assertions.assertTrue(employeeDAO.findById(10008).get().getFirstName().equals("John") );

    }
    @Test
    void deleteByIdTest() {
        Optional<Employee> employee = employeeRepository.findById(11001);
        if (employee.isEmpty()) {
            Employee employee1 = new Employee();
            employee1.setFirstName("John");
            employee1.setLastName("Johnson");
            employee1.setGender("M");
            employee1.setBirthDate(LocalDate.of(1999,1,1));
            employee1.setHireDate(LocalDate.of(2020,1,1));
            employee1.setId(11001);
            employeeRepository.save(employee1);
        }
        employeeDAO.deleteById(11001);
        Assertions.assertTrue(employeeRepository.findById(11001).isEmpty());
    }

    @Test
    void testFindEmployeeByLastNameMethod() {
        List<Employee> employeesByLatName = employeeDAO.findEmployeeByLastName("Nitsche");
        System.out.println(employeesByLatName);
        Assertions.assertTrue(!employeesByLatName.isEmpty());
    }
}