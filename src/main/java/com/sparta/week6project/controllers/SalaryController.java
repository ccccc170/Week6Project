package com.sparta.week6project.controllers;

import com.sparta.week6project.DAO.impl.SalaryDAO;
import com.sparta.week6project.DTO.SalaryDTO;
import com.sparta.week6project.entities.SalaryId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/salaries")
public class SalaryController {
    @Autowired
    SalaryDAO salaryDAO;

    @GetMapping("/")
    public SalaryDTO findById(@RequestBody SalaryId salaryId){
        SalaryDTO salaryDTO = null;
        System.out.println(salaryId);
        Optional<SalaryDTO> salaryDTOOptional = salaryDAO.findById(salaryId);
        if (salaryDTOOptional.isPresent()){
            salaryDTO = salaryDTOOptional.get();
        }
        System.out.println(salaryDTO);
        return salaryDTO;
    }
}
