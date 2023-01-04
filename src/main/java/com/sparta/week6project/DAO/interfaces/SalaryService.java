package com.sparta.week6project.DAO.interfaces;

import com.sparta.week6project.DTO.SalaryDTO;
import com.sparta.week6project.entities.SalaryId;

import java.util.Optional;

public interface SalaryService<T> {
    Optional<T> findById(SalaryId id);

    SalaryDTO save(SalaryDTO e);

    void update(SalaryDTO e);

    void deleteById(SalaryId id);

}
