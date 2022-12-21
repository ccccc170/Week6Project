package com.sparta.week5project.DAO.impl;

import com.sparta.week5project.DAO.interfaces.DAO;
import com.sparta.week5project.entities.DeptEmp;

import java.util.Optional;

public class DeptEmpDAO implements DAO<DeptEmp> {
    @Override
    public Optional<DeptEmp> findById(Integer id) {
        return null;
    }

    @Override
    public DeptEmp save(DeptEmp e) {
        return null;
    }

    @Override
    public void update(DeptEmp e) {

    }

    @Override
    public void deleteById(Integer id) {

    }
}
