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
import com.sparta.week6project.repositories.DeptManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/departmentManager")
public class DepartmentManagerController {
    @Autowired
    DepartmentManagerDAO departmentManagerDAO;
    @Autowired
    private DeptManagerRepository deptManagerRepository;

    @GetMapping("/")
    public DeptManagerDTO findById(@RequestParam Integer empNo, @RequestParam String deptNo){
        DeptManagerId deptManagerId = new DeptManagerId();
        deptManagerId.setDeptNo(deptNo);
        deptManagerId.setEmpNo(empNo);
        DeptManagerDTO deptManagerDTO = null;
        System.out.println(deptManagerId);
        Optional<DeptManagerDTO> deptEmpDTOOptional = null;
        try{
            deptEmpDTOOptional = departmentManagerDAO.findById(deptManagerId);
        }catch (Exception e){
            return new DeptManagerDTO();
        }

        System.out.println(deptEmpDTOOptional.get());
        if (deptEmpDTOOptional.isPresent()){
            deptManagerDTO = deptEmpDTOOptional.get();
        }
        return deptManagerDTO;
    }
    @PatchMapping("/")
    public DeptManagerDTO update(@RequestBody DeptManagerDTO deptManagerDTO){
        System.out.println(deptManagerDTO);
        DeptManagerId deptManagerId = new DeptManagerId();
        deptManagerId.setDeptNo(deptManagerDTO.getDeptNo());
        deptManagerId.setEmpNo(deptManagerDTO.getEmpNo());
        System.out.println(deptManagerId);
        DeptManagerDTO original = null;
        Optional<DeptManagerDTO> originalOptional = departmentManagerDAO.findById(deptManagerId);
        try{
            original = originalOptional.get();
            if (deptManagerDTO.getFromDate() != null){
                original.setFromDate(deptManagerDTO.getFromDate());
            }
            if (deptManagerDTO.getToDate() != null) {
                original.setToDate(deptManagerDTO.getToDate());
                departmentManagerDAO.update(original);
            }
        }catch (Exception e){
            return new DeptManagerDTO();
        }

        return original;
    }
    @PostMapping("/")
    public DeptManagerDTO create(@RequestBody DeptManagerDTO deptManagerDTO){
        DeptManagerId deptManagerId = new DeptManagerId();
        deptManagerId.setDeptNo(deptManagerDTO.getDeptNo());
        deptManagerId.setEmpNo(deptManagerDTO.getEmpNo());
        deptManagerDTO.setId(deptManagerId);
        System.out.println(deptManagerId);
        System.out.println(deptManagerDTO);
        if(deptManagerRepository.findById(deptManagerId).isEmpty()){
            System.out.println("Departmanager doesnt exist");
            //DeptManagerDTO newDeptManager = departmentManagerDAO.save(deptManagerDTO);
            deptManagerRepository.saveDeptManager(deptManagerDTO.getEmpNo(), deptManagerDTO.getDeptNo(),deptManagerDTO.getFromDate(), deptManagerDTO.getToDate());
            return deptManagerDTO;
        }else{
            System.out.println("department manager exist");
            return new DeptManagerDTO();
        }
        //return departmentManagerDAO.save(deptManagerDTO);
    }
    @DeleteMapping("/")
    public String delete(@RequestParam Integer empNo, @RequestParam String deptNo){
        DeptManagerId deptManagerId = new DeptManagerId();
        deptManagerId.setDeptNo(deptNo);
        deptManagerId.setEmpNo(empNo);
        try{
            if(departmentManagerDAO.findById(deptManagerId).isPresent()){
                departmentManagerDAO.deleteById(deptManagerId);
                return "{\"message\": " + "\"" + deptManagerId + " has been deleted!}" + "\"}";
            }
            return "{\"message\": " + "\"" + deptManagerId + " has been deleted!}" + "\"}";
        }catch (Exception e){
            return "{\"message\": " + "\"" + deptManagerId + " does not exist in department manager !" + "\"}";
        }
    }
}
