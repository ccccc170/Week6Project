package com.sparta.week6project.MapperImplTests;

import com.sparta.week6project.DTO.DepartmentDTO;
import com.sparta.week6project.entities.Department;
import com.sparta.week6project.mappers.impl.DepartmentMapperImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DepartmentMapperImplTest {
    @Autowired
    DepartmentMapperImpl departmentMapper;

    @Test
    void dtoToDepartmentTest() {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId("1");
        departmentDTO.setDeptName("name");

        Department result = departmentMapper.dtoToDepartment(departmentDTO);
        System.out.println(result);
        Assertions.assertEquals(departmentDTO.getDeptName(), result.getDeptName());
        Assertions.assertEquals(departmentDTO.getId(), result.getId());
    }

    @Test
    void departmentToDTOTest() {
        Department department = new Department();
        department.setId("2");
        department.setDeptName("department");

        DepartmentDTO result = departmentMapper.departmentToDTO(department);
        System.out.println(result);
        Assertions.assertEquals(department.getId(), result.getId());
        Assertions.assertEquals(department.getDeptName(), result.getDeptName());
    }
}
