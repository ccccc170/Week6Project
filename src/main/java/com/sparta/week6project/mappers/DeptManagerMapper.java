package com.sparta.week6project.mappers;

import com.sparta.week6project.DTO.DeptManagerDTO;
import com.sparta.week6project.entities.DeptManager;

public interface DeptManagerMapper {

    DeptManagerDTO deptManagerToDTO(DeptManager deptManager);
    DeptManager dtoToDeptManager(DeptManagerDTO deptManagerDTO);
}
