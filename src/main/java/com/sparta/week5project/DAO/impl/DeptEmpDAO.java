package com.sparta.week5project.DAO.impl;

import com.sparta.week5project.DAO.interfaces.DAO;
import com.sparta.week5project.entities.DeptEmp;

public class DeptEmpDAO implements DAO<DeptEmp> {
    @Override
    public DeptEmp findById(Integer id) {
        return null;
    }

    @Override
    public int save(DeptEmp e) {
        return 0;
    }

    @Override
    public void update(DeptEmp e) {

    }

    @Override
    public void deleteById(Integer id) {

    }
}
