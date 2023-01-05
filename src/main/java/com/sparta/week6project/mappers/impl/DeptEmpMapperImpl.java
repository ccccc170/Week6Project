package com.sparta.week6project.mappers.impl;


import com.sparta.week6project.DTO.DeptEmpDTO;
import com.sparta.week6project.entities.DeptEmp;
import com.sparta.week6project.mappers.DeptEmpMapper;
import com.sparta.week6project.repositories.DepartmentRepository;
import com.sparta.week6project.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeptEmpMapperImpl implements DeptEmpMapper {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public DeptEmpDTO deptEmpToDTO(DeptEmp deptEmp) {
        if(deptEmp == null) {
            return null;
        }

        DeptEmpDTO deptEmpDTO = new DeptEmpDTO();

        deptEmpDTO.setId(deptEmp.getId());
        deptEmpDTO.setEmpNo(deptEmp.getEmpNo().getId());
        deptEmpDTO.setDeptNo(deptEmp.getDeptNo().getId());
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
        deptEmp.setEmpNo(employeeRepository.findById(deptEmpDTO.getEmpNo()).get());
        deptEmp.setDeptNo(departmentRepository.findById(deptEmpDTO.getDeptNo()).get());
        deptEmp.setFromDate(deptEmpDTO.getFromDate());
        deptEmp.setToDate(deptEmpDTO.getToDate());

        return deptEmp;
    }
}
