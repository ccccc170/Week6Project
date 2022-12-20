package com.sparta.week5project.mappers;

import com.sparta.week5project.DTO.DeptManagerDTO;
import com.sparta.week5project.entities.DeptManager;

public interface DeptManagerMapper {

    DeptManagerDTO deptManagerToDTO(DeptManager deptManager);
    DeptManager dtoToDeptManager(DeptManagerDTO deptManagerDTO);
}
