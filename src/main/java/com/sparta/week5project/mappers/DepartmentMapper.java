package com.sparta.week5project.mappers;

import com.sparta.week5project.DTO.DepartmentDTO;
import com.sparta.week5project.entities.Department;

public interface DepartmentMapper {

    DepartmentDTO departmentToDTO(Department department);
    Department dtoToDepartment(DepartmentDTO departmentDTO);
}
