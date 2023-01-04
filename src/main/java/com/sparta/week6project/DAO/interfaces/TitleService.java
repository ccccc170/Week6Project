package com.sparta.week6project.DAO.interfaces;

import com.sparta.week6project.DTO.TitleDTO;
import com.sparta.week6project.entities.TitleId;

import java.util.Optional;

public interface TitleService<T> {

    Optional<T> findById(TitleId id);

    TitleDTO save(TitleDTO e);

    void update(TitleDTO e,TitleId id);

    void deleteById(TitleId id);
}
