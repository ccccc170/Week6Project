package com.sparta.week5project.DAO.interfaces;

import com.sparta.week5project.DTO.DeptEmpDTO;
import com.sparta.week5project.entities.DeptEmpId;

import java.util.Optional;

public interface DeptEmpService<T> {



    Optional<T> findById(DeptEmpId id);

    DeptEmpDTO save(DeptEmpDTO e);

    void update(DeptEmpDTO e);

    void deleteById(DeptEmpId id);
}
