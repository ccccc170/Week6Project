package com.sparta.week6project.DAO.impl;

import com.sparta.week6project.DAO.interfaces.TitleService;
import com.sparta.week6project.DTO.TitleDTO;
import com.sparta.week6project.entities.Title;
import com.sparta.week6project.entities.TitleId;
import com.sparta.week6project.mappers.TitleMapper;
import com.sparta.week6project.repositories.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TitleDAO implements TitleService {

    @Autowired
    private TitleMapper titleMapper;

    @Autowired
    private TitleRepository titleRepository;

    public TitleDAO(TitleMapper titleMapper, TitleRepository titleRepository) {
        this.titleMapper = titleMapper;
        this.titleRepository = titleRepository;
    }

    public TitleDAO() {
    }

    @Override
    public Optional<TitleDTO> findById(TitleId id) {
        if(titleRepository.findById(id).isPresent()) {
            return Optional.of(titleMapper.titleToDTO(titleRepository.findById(id).get()));
        }
        return Optional.empty();
    }

    @Override
    public TitleDTO save(TitleDTO e) {
        return titleMapper.titleToDTO(titleRepository.save(titleMapper.dtoToTitle(e)));
    }

    @Override
    public void update(TitleDTO e, TitleId id) {
        Optional<Title> titleDb = titleRepository.findById(id);
        if(titleDb.isPresent()) {
            Title updatedTitle = titleDb.get();
            updatedTitle.setEmpNo(e.getEmpNo());
            updatedTitle.setToDate(e.getToDate());
            titleRepository.save(updatedTitle);
        }
    }

    @Override
    public void deleteById(TitleId id) {
        if(titleRepository.findById(id).isPresent()) {
            titleRepository.deleteById(id);
        }
    }
}
