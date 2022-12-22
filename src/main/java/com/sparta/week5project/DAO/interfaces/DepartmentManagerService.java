package com.sparta.week5project.DAO.interfaces;

import com.sparta.week5project.DTO.DeptManagerDTO;
import com.sparta.week5project.entities.DeptManagerId;

import java.util.Optional;

public interface DepartmentManagerService <T> {
    Optional<T> findById(DeptManagerId id);

    DeptManagerDTO
    save(DeptManagerDTO e);

    void update(DeptManagerDTO e);

    void deleteById(DeptManagerId id);
}
