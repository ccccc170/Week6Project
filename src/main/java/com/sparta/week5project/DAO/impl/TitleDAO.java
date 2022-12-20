package com.sparta.week5project.DAO.impl;

import com.sparta.week5project.DAO.interfaces.DAO;
import com.sparta.week5project.entities.Title;

public class TitleDAO implements DAO<Title> {
    @Override
    public Title findById(Integer id) {
        return null;
    }

    @Override
    public int save(Title e) {
        return 0;
    }

    @Override
    public void update(Title e) {

    }

    @Override
    public void deleteById(Integer id) {

    }
}
