package com.sparta.week5project.DAO.impl;

import com.sparta.week5project.DAO.interfaces.DepartmentService;
import com.sparta.week5project.DTO.DepartmentDTO;
import com.sparta.week5project.entities.Department;
import com.sparta.week5project.mappers.impl.DepartmentMapperImpl;
import com.sparta.week5project.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

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
        return departmentMapper.departmentToDTO(departmentRepository.save(departmentMapper.dtoToDepartment(e)));
    }

    @Override
    public void update(DepartmentDTO e, String id) {
        Optional<Department> departmentDb = departmentRepository.findByIdNumber(id);
        if(departmentDb.isPresent()) {
            Department updatedDepartment = departmentDb.get();
            updatedDepartment.setDeptName(e.getDeptName());
            departmentRepository.save(updatedDepartment);
        }
    }

    @Override
    public void deleteById(String id) {
        if(departmentRepository.findByIdNumber(id).isPresent()) {
            departmentRepository.deleteById(id);
        }
    }

//    @Override
//    public Map<String, Integer> getDepartmentSizeByYearRange(Integer from, Integer to) {
//        return null;
//    }
}
