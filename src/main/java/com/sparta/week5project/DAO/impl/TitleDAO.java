package com.sparta.week5project.DAO.impl;

import com.sparta.week5project.DAO.interfaces.DAO;
import com.sparta.week5project.DAO.interfaces.TitleService;
import com.sparta.week5project.DTO.DeptEmpDTO;
import com.sparta.week5project.DTO.TitleDTO;
import com.sparta.week5project.entities.Title;
import com.sparta.week5project.entities.TitleId;
import com.sparta.week5project.mappers.TitleMapper;
import com.sparta.week5project.repositories.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TitleDAO implements TitleService {

    @Autowired
    private TitleMapper titleMapper;

    @Autowired
    private TitleRepository titleRepository;


    @Override
    public Optional<TitleDTO> findById(TitleId id) {
        return Optional.of(titleMapper.titleToDTO(titleRepository.findById(id).get()));
    }

    @Override
    public TitleDTO save(TitleDTO e) {
        return null;
    }

    @Override
    public void update(TitleDTO e) {

    }

    @Override
    public void deleteById(TitleId id) {

    }
}
