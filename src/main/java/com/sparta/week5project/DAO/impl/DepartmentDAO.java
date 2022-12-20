package com.sparta.week5project.DAO.impl;

import com.sparta.week5project.DAO.interfaces.DepartmentService;
import com.sparta.week5project.entities.Department;

import java.util.Map;

public class DepartmentDAO implements DepartmentService {
    @Override
    public Department findById(Integer id) {
        return null;
    }

    @Override
    public int save(Department e) {
        return 0;
    }

    @Override
    public void update(Department e) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Map<String, Integer> getDepartmentSizeByYearRange(Integer from, Integer to) {
        return null;
    }
}
