package com.sparta.week6project.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sparta.week6project.DAO.impl.DepartmentManagerDAO;
import com.sparta.week6project.DTO.DeptEmpDTO;
import com.sparta.week6project.DTO.DeptManagerDTO;
import com.sparta.week6project.DTO.EmployeeDTO;
import com.sparta.week6project.entities.DeptManagerId;
import com.sparta.week6project.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/departmentManager")
public class DepartmentManagerController {
    @Autowired
    DepartmentManagerDAO departmentManagerDAO;

    @GetMapping("/")
    public DeptManagerDTO findById(@RequestBody DeptManagerId deptManagerId){
//        DeptManagerId deptManagerId = new DeptManagerId();
//        deptManagerId.setDeptNo(deptNo);
//        deptManagerId.setEmpNo(empNo);
        DeptManagerDTO deptManagerDTO = null;
        System.out.println(deptManagerId);
        Optional<DeptManagerDTO> deptEmpDTOOptional = departmentManagerDAO.findById(deptManagerId);
        System.out.println(deptEmpDTOOptional.get());
        if (deptEmpDTOOptional.isPresent()){
            deptManagerDTO = deptEmpDTOOptional.get();
            //System.out.println(deptEmpDTOOptional);
        }
        return deptManagerDTO;
    }
}
