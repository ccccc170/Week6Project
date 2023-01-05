package com.sparta.week6project.controllers;

import com.sparta.week6project.DAO.impl.DepartmentDAO;
import com.sparta.week6project.DTO.DepartmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentDAO departmentDAO;

    @GetMapping
    public DepartmentDTO findByDept_No(@RequestParam String dept_no) {
        return departmentDAO.findByDept_No(dept_no).get();
    }

    @PostMapping("/")
    public DepartmentDTO save(@RequestBody DepartmentDTO departmentDTO) {
        return departmentDAO.save(departmentDTO);
    }

    @PutMapping("/")
    public DepartmentDTO update(@RequestBody DepartmentDTO departmentDTO) {
        Optional<DepartmentDTO> originalOptional = departmentDAO.findByDept_No(departmentDTO.getId());
        if (originalOptional.isPresent()) {
            DepartmentDTO original = originalOptional.get();
            if (departmentDTO.getDeptName() != null) {
                original.setDeptName(departmentDTO.getDeptName());
            }
            return departmentDAO.save(original);
        }
        return new DepartmentDTO();
    }

    @DeleteMapping("/")
    public void deleteById(@RequestParam String id) {
        departmentDAO.deleteById(id);
    }

}
