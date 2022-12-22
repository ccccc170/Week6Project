package com.sparta.week5project.DAO.impl;

import com.sparta.week5project.DAO.interfaces.SalaryService;

import com.sparta.week5project.DTO.SalaryDTO;
import com.sparta.week5project.entities.SalaryId;
import com.sparta.week5project.mappers.SalaryMapper;
import com.sparta.week5project.repositories.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@EnableAutoConfiguration
public class SalaryDAO implements SalaryService {

    @Autowired
    private SalaryMapper salaryMapper;

    @Autowired
    private SalaryRepository salaryRepository;

    public SalaryDAO(SalaryMapper salaryMapper, SalaryRepository salaryRepository) {
        this.salaryMapper = salaryMapper;
        this.salaryRepository = salaryRepository;
    }

    public SalaryDAO (){

    }

    @Override
    public Optional<SalaryDTO> findById(SalaryId id) {
        return Optional.of(salaryMapper.salaryToDTO(salaryRepository.findById(id).get()));
    }

    @Override
    public SalaryDTO save(SalaryDTO e) {
        return salaryMapper.salaryToDTO(salaryRepository.save(salaryMapper.dtoToSalary(e)));
    }

    @Override
    public void update(SalaryDTO e) {
        e.setSalary(e.getSalary()+10000);
        salaryRepository.save(salaryMapper.dtoToSalary(e));
    }

    @Override
    public void deleteById(SalaryId id) {
        salaryRepository.deleteById(id);
    }

}
