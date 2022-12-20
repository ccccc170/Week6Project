package com.sparta.week5project.DAO.impl;

import com.sparta.week5project.DAO.interfaces.DAO;
import com.sparta.week5project.entities.DeptManager;

public class DepartmentManagerDAO implements DAO<DeptManager> {
    @Override
    public DeptManager findById(Integer id) {
        return null;
    }

    @Override
    public int save(DeptManager e) {
        return 0;
    }

    @Override
    public void update(DeptManager e) {

    }

    @Override
    public void deleteById(Integer id) {

    }
}
