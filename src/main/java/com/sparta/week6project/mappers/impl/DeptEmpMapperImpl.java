package com.sparta.week6project.mappers.impl;


import com.sparta.week6project.DTO.DeptEmpDTO;
import com.sparta.week6project.entities.DeptEmp;
import com.sparta.week6project.mappers.DeptEmpMapper;
import org.springframework.stereotype.Component;

@Component
public class DeptEmpMapperImpl implements DeptEmpMapper {
    @Override
    public DeptEmpDTO deptEmpToDTO(DeptEmp deptEmp) {
        if(deptEmp == null) {
            return null;
        }

        DeptEmpDTO deptEmpDTO = new DeptEmpDTO();

        deptEmpDTO.setId(deptEmp.getId());
        deptEmpDTO.setEmpNo(deptEmp.getEmpNo());
        deptEmpDTO.setDeptNo(deptEmp.getDeptNo());
        deptEmpDTO.setFromDate(deptEmp.getFromDate());
        deptEmpDTO.setToDate(deptEmp.getToDate());

        return deptEmpDTO;
    }

    @Override
    public DeptEmp dtoToDeptEmp(DeptEmpDTO deptEmpDTO) {
        if(deptEmpDTO == null) {
            return null;
        }

        DeptEmp deptEmp = new DeptEmp();

        deptEmp.setId(deptEmpDTO.getId());
        deptEmp.setEmpNo(deptEmpDTO.getEmpNo());
        deptEmp.setDeptNo(deptEmpDTO.getDeptNo());
        deptEmp.setFromDate(deptEmpDTO.getFromDate());
        deptEmp.setToDate(deptEmpDTO.getToDate());

        return deptEmp;
    }
}
