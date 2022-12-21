package com.sparta.week5project.DAO.impl;

import com.sparta.week5project.DAO.interfaces.DepartmentService;
import com.sparta.week5project.DTO.DepartmentDTO;
import com.sparta.week5project.entities.Department;
import com.sparta.week5project.mappers.impl.DepartmentMapperImpl;
import com.sparta.week5project.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@EnableAutoConfiguration
public class DepartmentDAO implements DepartmentService {
    @Autowired
    private DepartmentMapperImpl departmentMapper;

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentDAO(DepartmentMapperImpl departmentMapper, DepartmentRepository departmentRepository) {
        this.departmentMapper = departmentMapper;
        this.departmentRepository = departmentRepository;
    }

    public DepartmentDAO() {
    }

    @Override
    public Optional<DepartmentDTO> findByDept_No(String dept_no) {
        return Optional.of(departmentMapper.departmentToDTO(departmentRepository.findByIdNumber(dept_no).get()));
    }

    @Override
    public DepartmentDTO save(DepartmentDTO e) {
        return null;
    }

    @Override
    public void update(DepartmentDTO e) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Map<String, Integer> getDepartmentSizeByYearRange(Integer from, Integer to) {
        return null;
    }
}
