package com.sparta.week6project.mappers.impl;

import com.sparta.week6project.DTO.TitleDTO;
import com.sparta.week6project.entities.Title;
import com.sparta.week6project.mappers.TitleMapper;
import org.springframework.stereotype.Component;

@Component
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