package com.sparta.week5project.DAO.impl;

import com.sparta.week5project.DAO.interfaces.SalaryService;
import com.sparta.week5project.DTO.SalaryDTO;
import com.sparta.week5project.entities.SalaryId;
import com.sparta.week5project.mappers.SalaryMapper;
import com.sparta.week5project.repositories.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
public class SalaryDAO implements SalaryService {

    @Autowired
    private SalaryMapper salaryMapper;

    @Autowired
    private SalaryRepository salaryRepository;

    @Override
    public Optional<SalaryDTO> findById(SalaryId id) {
        return Optional.of(salaryMapper.SalaryToDTO(salaryRepository.findById(id).get()));
    }

    @Override
    public SalaryDTO save(SalaryDTO e) {

        return salaryMapper.SalaryToDTO(salaryRepository.save(salaryMapper.dtoToSalary(e)));
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
