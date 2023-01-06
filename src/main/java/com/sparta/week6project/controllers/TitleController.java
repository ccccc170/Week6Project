package com.sparta.week6project.controllers;

import com.sparta.week6project.DAO.impl.TitleDAO;
import com.sparta.week6project.DTO.TitleDTO;
import com.sparta.week6project.entities.TitleId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("api/titles")

public class TitleController {
    
    @Autowired
    TitleDAO titleDAO;

    @GetMapping("/")
    public TitleDTO findById(@RequestBody TitleId titleId){
        TitleDTO titleDTO = null;
        System.out.println(titleId);
        Optional<TitleDTO> TitleDTOOptional = titleDAO.findById(titleId);
        if (TitleDTOOptional.isPresent()){
            titleDTO = TitleDTOOptional.get();
        }
        System.out.println(titleDTO);
        return titleDTO;
    }

    @PostMapping("/")
    public TitleDTO save(@RequestBody TitleDTO titleDTO){ // Note you cannot provide a Title DTO where the TitleID emp no doesn't exist in the employees table
        return titleDAO.save(titleDTO);
    }

    @PatchMapping("/")
    public TitleDTO update(@RequestBody TitleDTO titleDTO){
        Optional<TitleDTO> titleDTOOptional = null;
        try {
            titleDTOOptional = titleDAO.findById(titleDTO.getId());
        } catch (NoSuchElementException e){
            e.printStackTrace();
        }
        TitleDTO updateableTitle = null;
        if (titleDTOOptional.isPresent()) {
            updateableTitle = titleDTOOptional.get();
            if (titleDTO.getToDate() != null) {
                updateableTitle.setToDate(titleDTO.getToDate());
            }
            return titleDAO.save(updateableTitle);
        }
        return new TitleDTO();
    }

    @DeleteMapping("/")
    public void deleteById(@RequestBody TitleId titleId){
        titleDAO.deleteById(titleId);
    }
}
