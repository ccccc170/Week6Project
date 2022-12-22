package com.sparta.week5project.DAO.interfaces;

import com.sparta.week5project.DTO.TitleDTO;
import com.sparta.week5project.entities.TitleId;

import java.util.Optional;

public interface TitleService<T> {

    Optional<T> findById(TitleId id);

    TitleDTO save(TitleDTO e);

    void update(TitleDTO e);

    void deleteById(TitleId id);
}
