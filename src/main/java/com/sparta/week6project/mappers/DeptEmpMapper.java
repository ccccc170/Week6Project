package com.sparta.week6project.mappers;

import com.sparta.week6project.DTO.DeptEmpDTO;
import com.sparta.week6project.entities.DeptEmp;

public interface DeptEmpMapper {
    DeptEmpDTO deptEmpToDTO(DeptEmp deptEmp);
    DeptEmp dtoToDeptEmp(DeptEmpDTO deptEmpDTO);
}
