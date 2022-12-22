package com.sparta.week5project.DAO.impl;

import com.sparta.week5project.DAO.interfaces.DAO;
import com.sparta.week5project.DAO.interfaces.DepartmentManagerService;
import com.sparta.week5project.DTO.DeptEmpDTO;
import com.sparta.week5project.DTO.DeptManagerDTO;
import com.sparta.week5project.entities.DeptManager;
import com.sparta.week5project.entities.DeptManagerId;
import com.sparta.week5project.mappers.DeptManagerMapper;
import com.sparta.week5project.repositories.DeptManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentManagerDAO implements DepartmentManagerService<DeptManagerDTO> {
    @Autowired
    private DeptManagerRepository deptManagerRepository;

    @Autowired
    private DeptManagerMapper deptManagerMapper;

    @Override
    public Optional<DeptManagerDTO> findById(DeptManagerId id) {
        return Optional.of(deptManagerMapper.deptManagerToDTO(deptManagerRepository.findById(id).get()));
    }

    @Override
    public DeptManagerDTO save(DeptManagerDTO e) {
        return null;
    }

    @Override
    public void update(DeptManagerDTO e) {

    }

    @Override
    public void deleteById(DeptManagerId id) {

    }
}
