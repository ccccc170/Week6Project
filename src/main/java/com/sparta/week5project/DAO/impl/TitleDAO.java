package com.sparta.week5project.DAO.impl;

import com.sparta.week5project.DAO.interfaces.DAO;
import com.sparta.week5project.entities.Title;

import java.util.Optional;

public class TitleDAO implements DAO<Title> {
    @Override
    public Optional<Title> findById(Integer id) {
        return null;
    }

    @Override
    public Title save(Title e) {
        return null;
    }

    @Override
    public void update(Title e) {

    }

    @Override
    public void deleteById(Integer id) {

    }
}
