package com.sparta.week6project.controllers;

import com.sparta.week6project.DAO.impl.EmployeeDAO;
import com.sparta.week6project.DTO.EmployeeDTO;
import com.sparta.week6project.entities.Employee;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")

public class EmployeeController {
    @Autowired
    EmployeeDAO employeeDAO;

    @GetMapping("/{id}")
    public EmployeeDTO findByID(@PathVariable Integer id){
            return employeeDAO.findById(id).get();
    }

    @PostMapping("/")
    public EmployeeDTO save(@RequestBody EmployeeDTO employeeDTO){
            return employeeDAO.save(employeeDTO);
    }

    @PatchMapping("/")
    public EmployeeDTO update(@RequestBody EmployeeDTO newEmployeeDTO){

            Optional<EmployeeDTO> originalOptional =  employeeDAO.findById(newEmployeeDTO.getId());
            EmployeeDTO original = null;
            if(originalOptional.isPresent()){
                original = originalOptional.get();
                if(newEmployeeDTO.getFirstName() != null){
                    original.setFirstName(newEmployeeDTO.getFirstName());
                }
                if(newEmployeeDTO.getLastName() != null){
                    original.setLastName(newEmployeeDTO.getLastName());
                }
                if(newEmployeeDTO.getBirthDate() != null){
                    original.setBirthDate(newEmployeeDTO.getBirthDate());
                }
                if(newEmployeeDTO.getHireDate() != null){
                    original.setHireDate(newEmployeeDTO.getHireDate());
                }
                if(newEmployeeDTO.getGender() != null){
                    original.setGender(newEmployeeDTO.getGender());
                }
                return employeeDAO.save(original);
            }

            return new EmployeeDTO();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
            employeeDAO.deleteById(id);
    }

    @GetMapping("/")
    public List<Employee> findByLastName(@RequestParam String lastName){
            return employeeDAO.findEmployeeByLastName(lastName);
    }

}
