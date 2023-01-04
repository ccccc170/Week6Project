package com.sparta.week6project.DAO.impl;

import com.sparta.week6project.DTO.TitleDTO;
import com.sparta.week6project.entities.Employee;
import com.sparta.week6project.entities.Title;
import com.sparta.week6project.entities.TitleId;
import com.sparta.week6project.mappers.TitleMapper;
import com.sparta.week6project.mappers.impl.EmployeeMapperImpl;
import com.sparta.week6project.repositories.TitleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
class TitleDAOTest {

    @Autowired
    private TitleDAO titleDAO;

    @Autowired
    private TitleRepository titleRepository;

    @Autowired
    private TitleMapper titleMapper;

    @Autowired
    EmployeeDAO employeeDAO;

    @Autowired
    private EmployeeMapperImpl employeeMapper;

    @Test
    void findByIdTest() {
        TitleId titleId = new TitleId();
        titleId.setTitle("Senior Engineer");
        titleId.setEmpNo(10001);
        titleId.setFromDate(LocalDate.of(1986,6,26));
        Optional<TitleDTO> employee = titleDAO.findById(titleId);
        Assertions.assertTrue(employee.isPresent());
    }

    @Test
    @Rollback
    void save() {
        Employee employee1 = new Employee();
        employee1.setFirstName("John");
        employee1.setLastName("Johnson");
        employee1.setGender("M");
        employee1.setBirthDate(LocalDate.of(1999,1,1));
        employee1.setHireDate(LocalDate.of(2020,1,1));
        employee1.setId(100010);

        TitleId titleId = new TitleId();
        titleId.setTitle("Senior Engineer");
        titleId.setEmpNo(100010);
        titleId.setFromDate(LocalDate.of(2020,1,1));
        TitleDTO titleDTO = new TitleDTO();
        titleDTO.setId(titleId);
        titleDTO.setEmpNo(employee1);
        titleDTO.setToDate(LocalDate.of(2022,5,5));

        Optional<Title> title = titleRepository.findById(titleId);
        if(title.isEmpty()) {
            titleDAO.save(titleDTO);
        }
        Assertions.assertTrue(titleDAO.findById(titleId).get().getEmpNo().getId().equals(100010));
    }

    @Test
    @Rollback
    void updateTest() {
        Employee employee1 = new Employee();
        employee1.setFirstName("Peter");
        employee1.setLastName("Johnson");
        employee1.setGender("M");
        employee1.setBirthDate(LocalDate.of(1999,1,1));
        employee1.setHireDate(LocalDate.of(2020,1,1));
        employee1.setId(1000100);

        TitleId titleId = new TitleId();
        titleId.setTitle("Staff");
        titleId.setEmpNo(10002);
        titleId.setFromDate(LocalDate.of(1996, 8,3));

        TitleDTO titleDTO = new TitleDTO();
        titleDTO.setToDate(LocalDate.of(2022,1,1));
        titleDTO.setId(titleId);
        titleDTO.setEmpNo(employee1);
        Optional<Title> titleDB = titleRepository.findById(titleId);
        if(titleDB.isPresent()) {
            titleDB.get().setEmpNo(titleDTO.getEmpNo());
            titleDB.get().setToDate(titleDTO.getToDate());
            titleRepository.save((titleDB.get()));
        }
        titleDAO.update(titleDTO, titleId);
        Assertions.assertEquals(titleDAO.findById(titleId).get().getId().getEmpNo(), 10002);
    }


    @Test
    @Rollback
    void deleteById() {
        TitleId titleId = new TitleId();
        titleId.setTitle("Senior Staff");
        titleId.setEmpNo(10671);
        titleId.setFromDate(LocalDate.of(2020,1,1));
        Optional<Title> title  = titleRepository.findById(titleId);
        if (title.isEmpty()) {

            Employee employee1 = new Employee();
            employee1.setFirstName("Peter");
            employee1.setLastName("Johnson");
            employee1.setGender("M");
            employee1.setBirthDate(LocalDate.of(1999,1,1));
            employee1.setHireDate(LocalDate.of(2020,1,1));
            employee1.setId(10001000);
            employeeDAO.save(employeeMapper.employeeToDto(employee1));

            TitleDTO titleDTO = new TitleDTO();
            titleDTO.setToDate(LocalDate.of(2022,1,1));
            titleDTO.setId(titleId);
            titleDTO.setEmpNo(employee1);
            titleDAO.save(titleDTO);
        }
        titleDAO.deleteById(titleId);
        Assertions.assertTrue(titleDAO.findById(titleId).isEmpty());

        titleDAO.deleteById(titleId);
    }

    @Test
    void titleDAOTest() {
        TitleDAO titleDAO1 = new TitleDAO(titleMapper, titleRepository);
        Assertions.assertNotNull(titleDAO1);
    }
}