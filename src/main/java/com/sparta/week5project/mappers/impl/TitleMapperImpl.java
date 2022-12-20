package com.sparta.week5project.mappers.impl;

import com.sparta.week5project.DTO.TitleDTO;
import com.sparta.week5project.entities.Title;
import com.sparta.week5project.mappers.TitleMapper;

public class TitleMapperImpl implements TitleMapper {

    @Override
    public TitleDTO titleToDTO(Title title) {
        if (title == null){
            return null;
        }
        TitleDTO titleDTO = new TitleDTO();
        titleDTO.setId(title.getId());
        titleDTO.setToDate(title.getToDate());
        titleDTO.setEmpNo(title.getEmpNo());
        return titleDTO;
    }

    @Override
    public Title dtoToTitle(TitleDTO titleDTO) {
        if(titleDTO == null){
            return null;
        }
        Title title = new Title();
        title.setId(titleDTO.getId());
        title.setToDate(titleDTO.getToDate());
        title.setEmpNo(titleDTO.getEmpNo());
        return title;
    }
}