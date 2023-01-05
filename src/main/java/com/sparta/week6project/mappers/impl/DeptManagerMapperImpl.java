package com.sparta.week6project.mappers.impl;

import com.sparta.week6project.DTO.DeptManagerDTO;
import com.sparta.week6project.entities.DeptManager;
import com.sparta.week6project.mappers.DeptManagerMapper;
import com.sparta.week6project.repositories.DeptManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeptManagerMapperImpl implements DeptManagerMapper {
    @Autowired
    DeptManagerRepository deptManagerRepository;
    @Override
    public DeptManagerDTO deptManagerToDTO(DeptManager deptManager) {
        if(deptManager == null) {
            return null;
        }
        DeptManagerDTO deptManagerDTO = new DeptManagerDTO();
        deptManagerDTO.setId(deptManager.getId());
        deptManagerDTO.setDeptNo(deptManager.getDeptNo().getId());
        deptManagerDTO.setEmpNo(deptManager.getEmpNo().getId());
        deptManagerDTO.setFromDate(deptManager.getFromDate());
        deptManagerDTO.setToDate(deptManager.getToDate());

        return deptManagerDTO;
    }

    @Override
    public DeptManager dtoToDeptManager(DeptManagerDTO deptManagerDTO) {
        if(deptManagerDTO == null) {
            return null;
        }
        DeptManager deptManager = new DeptManager();
        deptManager.setId(deptManagerDTO.getId());
        deptManager.setDeptNo(deptManagerRepository.findById(deptManagerDTO.getId()).get().getDeptNo());
        deptManager.setEmpNo(deptManagerRepository.findById(deptManagerDTO.getId()).get().getEmpNo());
        deptManager.setFromDate(deptManagerDTO.getFromDate());
        deptManager.setToDate(deptManagerDTO.getToDate());

        return deptManager;
    }
}
