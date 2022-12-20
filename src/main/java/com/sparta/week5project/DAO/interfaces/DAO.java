package com.sparta.week5project.DAO.interfaces;

import com.sparta.week5project.entities.Employee;

public interface DAO<T> {

    T findById(Integer id);

    int save(T e);

    void update(T e);

    void deleteById(Integer id);
}

