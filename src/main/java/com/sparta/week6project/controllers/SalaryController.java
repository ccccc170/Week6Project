package com.sparta.week6project.controllers;

import com.sparta.week6project.DAO.impl.SalaryDAO;
import com.sparta.week6project.DTO.SalaryDTO;
import com.sparta.week6project.entities.SalaryId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
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

    @PostMapping("/")
    public SalaryDTO save(@RequestBody SalaryDTO salaryDTO){ // Note you cannot provide a salary DTO where the salaryID emp no doesn't exist in the employees table
        return salaryDAO.save(salaryDTO);
    }

    @PatchMapping("/")
    public SalaryDTO update(@RequestBody SalaryDTO salaryDTO){
        Optional<SalaryDTO> salaryDTOOptional = null;
        try {
            salaryDTOOptional = salaryDAO.findById(salaryDTO.getId());
        } catch (NoSuchElementException e){
            e.printStackTrace();
        }
        SalaryDTO updateableSalary = null;
            if (salaryDTOOptional.isPresent()) {
                updateableSalary = salaryDTOOptional.get();
                if (salaryDTO.getSalary() != null) {
                    updateableSalary.setSalary(salaryDTO.getSalary());
                }
                if (salaryDTO.getToDate() != null) {
                    updateableSalary.setToDate(salaryDTO.getToDate());
                }
                return salaryDAO.save(updateableSalary);
            }
            return new SalaryDTO();
    }


}

