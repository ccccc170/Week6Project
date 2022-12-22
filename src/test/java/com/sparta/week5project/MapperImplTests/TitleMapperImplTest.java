package com.sparta.week5project.MapperImplTests;

import com.sparta.week5project.DTO.TitleDTO;
import com.sparta.week5project.entities.Employee;
import com.sparta.week5project.entities.Title;
import com.sparta.week5project.entities.TitleId;
import com.sparta.week5project.mappers.impl.TitleMapperImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class TitleMapperImplTest {
    @Autowired
    TitleMapperImpl titleMapper;

    @Test
    void titleToDTOTest() {
        Title title = new Title();
        TitleId titleId = new TitleId();
        Employee employee = new Employee();
        titleId.setTitle("Sir");
        titleId.setEmpNo(11);
        titleId.setFromDate(LocalDate.of(2010, 01, 01));
        employee.setId(24);
        employee.setGender("M");
        employee.setFirstName("Dennis");
        employee.setLastName("Watts");
        employee.setBirthDate(LocalDate.of(1960, 01, 01));
        employee.setHireDate(LocalDate.of(2011,01 ,01));
        title.setToDate(LocalDate.of(2010, 01, 01));
        title.setId(titleId);
        title.setEmpNo(employee);

        TitleDTO result = titleMapper.titleToDTO(title);
        System.out.println(result);
        Assertions.assertEquals(title.getId(), result.getId());
        Assertions.assertEquals(title.getToDate(), result.getToDate());
        Assertions.assertEquals(title.getEmpNo(), result.getEmpNo());
    }

    @Test
    void dtoToTitleTest() {
        TitleDTO titleDTO = new TitleDTO();
        TitleId titleId = new TitleId();
        Employee employee = new Employee();
        titleId.setTitle("Miss");
        titleId.setEmpNo(113);
        titleId.setFromDate(LocalDate.of(2011, 01, 01));
        employee.setId(243);
        employee.setGender("F");
        employee.setFirstName("Sharron");
        employee.setLastName("Watts");
        employee.setBirthDate(LocalDate.of(1970, 01, 01));
        employee.setHireDate(LocalDate.of(2012,01 ,01));
        titleDTO.setToDate(LocalDate.of(2014, 01, 01));
        titleDTO.setId(titleId);
        titleDTO.setEmpNo(employee);

        Title result = titleMapper.dtoToTitle(titleDTO);
        System.out.println(result);
        Assertions.assertEquals(titleDTO.getId(), result.getId());
        Assertions.assertEquals(titleDTO.getToDate(), result.getToDate());
        Assertions.assertEquals(titleDTO.getEmpNo(), result.getEmpNo());
    }
}
