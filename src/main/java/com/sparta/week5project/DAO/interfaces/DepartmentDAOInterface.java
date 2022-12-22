package com.sparta.week5project.DAO.interfaces;

import com.sparta.week5project.DTO.DepartmentDTO;

import java.util.Optional;

public interface DepartmentDAOInterface {
    Optional<DepartmentDTO> findByDept_No(String dept_no);

    DepartmentDTO save(DepartmentDTO e);

    void update(DepartmentDTO e);

    void deleteById(Integer id);
}
