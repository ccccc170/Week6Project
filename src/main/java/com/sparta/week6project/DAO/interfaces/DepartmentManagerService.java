package com.sparta.week6project.DAO.interfaces;

import com.sparta.week6project.DTO.DeptManagerDTO;
import com.sparta.week6project.entities.DeptManagerId;

import java.util.Optional;

public interface DepartmentManagerService <T> {
    Optional<T> findById(DeptManagerId id);

    DeptManagerDTO
    save(DeptManagerDTO e);

    void update(DeptManagerDTO e, DeptManagerId id);

    void deleteById(DeptManagerId id);
}
