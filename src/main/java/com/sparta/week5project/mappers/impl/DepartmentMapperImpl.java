package com.sparta.week5project.mappers.impl;

import com.sparta.week5project.DTO.DepartmentDTO;
import com.sparta.week5project.entities.Department;
import com.sparta.week5project.mappers.DepartmentMapper;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapperImpl implements DepartmentMapper {
    @Override
    public DepartmentDTO departmentToDTO(Department department) {
        if(department == null) {
            return null;
        }
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId(department.getId());
        departmentDTO.setDeptName(department.getDeptName());

        return  departmentDTO;
    }

    @Override
    public Department dtoToDepartment(DepartmentDTO departmentDTO) {
        if(departmentDTO == null) {
            return null;
        }
        Department department = new Department();
        department.setId(departmentDTO.getId());
        department.setDeptName(departmentDTO.getDeptName());

        return  department;
    }
}
