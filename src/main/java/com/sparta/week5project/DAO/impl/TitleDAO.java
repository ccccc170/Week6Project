package com.sparta.week5project.DAO.impl;

import com.sparta.week5project.DAO.interfaces.DAO;
import com.sparta.week5project.DTO.DeptEmpDTO;
import com.sparta.week5project.DTO.TitleDTO;
import com.sparta.week5project.entities.Title;

import java.util.Optional;

public class TitleDAO implements DAO<TitleDTO> {
    @Override
    public Optional<TitleDTO> findById(Integer id) {
        return null;
    }

    @Override
    public TitleDTO save(TitleDTO e) {
        return null;
    }

    @Override
    public void update(TitleDTO e) {

    }

    @Override
    public void deleteById(Integer id) {

    }
}
