package com.sparta.week5project.DAO.impl;

import com.sparta.week5project.DAO.interfaces.DAO;
import com.sparta.week5project.DTO.DeptEmpDTO;
import com.sparta.week5project.entities.DeptEmp;

import java.util.Optional;

public class DeptEmpDAO implements DAO<DeptEmpDTO> {
    @Override
    public Optional<DeptEmpDTO> findById(Integer id) {
        return null;
    }

    @Override
    public DeptEmpDTO save(DeptEmpDTO e) {
        return null;
    }

    @Override
    public void update(DeptEmpDTO e) {

    }

    @Override
    public void deleteById(Integer id) {

    }
}
