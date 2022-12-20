package com.sparta.week5project.mappers;

import com.sparta.week5project.DTO.TitleDTO;
import com.sparta.week5project.entities.Title;

public interface TitleMapper {

    TitleDTO titleToDTO(Title title);
    Title dtoToTitle(TitleDTO titleDTO);
}