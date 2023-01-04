package com.sparta.week6project.DAO.interfaces;

import java.util.Optional;

public interface DAO<T> {

    Optional<T> findById(Integer id);

    T save(T e);

    void deleteById(Integer id);
}

