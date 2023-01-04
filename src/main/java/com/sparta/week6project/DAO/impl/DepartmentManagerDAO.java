package com.sparta.week6project.DAO.impl;

import com.sparta.week6project.DAO.interfaces.DepartmentManagerService;
import com.sparta.week6project.DTO.DeptManagerDTO;
import com.sparta.week6project.entities.DeptManager;
import com.sparta.week6project.entities.DeptManagerId;
import com.sparta.week6project.mappers.impl.DeptManagerMapperImpl;
import com.sparta.week6project.repositories.DeptManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentManagerDAO implements DepartmentManagerService<DeptManagerDTO> {
    @Autowired
    private DeptManagerRepository deptManagerRepository;

    @Autowired
    private DeptManagerMapperImpl deptManagerMapper;

    public DepartmentManagerDAO(DeptManagerRepository deptManagerRepository, DeptManagerMapperImpl deptManagerMapper) {
        this.deptManagerRepository = deptManagerRepository;
        this.deptManagerMapper = deptManagerMapper;
    }

    public DepartmentManagerDAO() {
    }

    @Override
    public Optional<DeptManagerDTO> findById(DeptManagerId id) {
        return Optional.of(deptManagerMapper.deptManagerToDTO(deptManagerRepository.findById(id).get()));
    }

    @Override
    public DeptManagerDTO save(DeptManagerDTO e) {
        return deptManagerMapper.deptManagerToDTO(deptManagerRepository.save(deptManagerMapper.dtoToDeptManager(e)));
    }


    @Override
    public void update(DeptManagerDTO e, DeptManagerId id) {
        Optional<DeptManager> departmentManagerDb = deptManagerRepository.findById(id);
        if (departmentManagerDb.isPresent()) {
            DeptManager updatedDepartmentManager = departmentManagerDb.get();
            updatedDepartmentManager.setFromDate(e.getFromDate());
            updatedDepartmentManager.setToDate(e.getToDate());
            updatedDepartmentManager.setDeptNo(e.getDeptNo());
            updatedDepartmentManager.setEmpNo(e.getEmpNo());
            deptManagerRepository.save(updatedDepartmentManager);
        }
    }

    @Override
    public void deleteById(DeptManagerId id) {
        if (deptManagerRepository.findById(id).isPresent()) {
            deptManagerRepository.deleteById(id);
        }
    }
}
