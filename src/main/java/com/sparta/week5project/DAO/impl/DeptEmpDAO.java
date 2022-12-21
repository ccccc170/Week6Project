package com.sparta.week5project.DAO.impl;

import com.sparta.week5project.DAO.interfaces.DAO;
import com.sparta.week5project.DAO.interfaces.DeptEmpService;
import com.sparta.week5project.DTO.DeptEmpDTO;
import com.sparta.week5project.entities.DeptEmp;
import com.sparta.week5project.entities.DeptEmpId;
import com.sparta.week5project.mappers.DeptEmpMapper;
import com.sparta.week5project.repositories.DepartmentRepository;
import com.sparta.week5project.repositories.DeptEmpRepository;
import com.sparta.week5project.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class DeptEmpDAO implements DeptEmpService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DeptEmpRepository deptEmpRepository;

    @Autowired
    private DeptEmpMapper deptEmpMapper;


    @Override
    public Optional findById(DeptEmpId id) {
        return Optional.of(deptEmpMapper.deptEmpToDTO(deptEmpRepository.findById(id).get()));
    }

    @Override
    public DeptEmpDTO save(DeptEmpDTO e) {
        return deptEmpMapper.deptEmpToDTO(deptEmpRepository.save(deptEmpMapper.dtoToDeptEmp(e)));
    }

    @Override
    public void update(DeptEmpDTO e) {

    }

    @Override
    public void deleteById(DeptEmpId id) {
        deptEmpRepository.deleteById(id);

    }
}
