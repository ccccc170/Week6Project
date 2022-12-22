package com.sparta.week5project.DAO.interfaces;

import com.sparta.week5project.DTO.DeptEmpDTO;

import java.util.Optional;

public interface DAO<T> {

    Optional<T> findById(Integer id);

    T save(T e);

    void update(T e);

    void deleteById(Integer id);
}

