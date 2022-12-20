package com.sparta.week5project.DAO.interfaces;

import com.sparta.week5project.entities.Department;

import java.util.Map;

public interface DepartmentService extends DAO<Department> {


    Map<String, Integer> getDepartmentSizeByYearRange(Integer from, Integer to);
}
