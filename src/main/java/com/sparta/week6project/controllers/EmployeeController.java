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
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")

public class EmployeeController {
    @Autowired
    EmployeeDAO employeeDAO;

    private Logger logger = LogManager.getRootLogger();

    @GetMapping("/{id}")
    public EmployeeDTO findByID(@PathVariable Integer id){

        try {
            logger.info("Getting Employee ID " + id);
            return employeeDAO.findById(id).get();

        } catch (NoSuchElementException e){
            logger.info(e.getMessage());
            logger.error("Employee ID " + id + " does not exist");
            return null;
        }
    }

    @PostMapping("/")
    public EmployeeDTO save(@RequestBody EmployeeDTO employeeDTO){
        try {
            logger.info(employeeDTO.toString() + " has been added to the database");
            return employeeDAO.save(employeeDTO);

        } catch (HttpMessageNotReadableException e){
            logger.info(e.getMessage());

            logger.error("Could not save the HTTP request - HTTP request may need restructuring");
            return null;
        }
    }

    @PatchMapping("/")
    public EmployeeDTO update(@RequestBody EmployeeDTO newEmployeeDTO){
        try {
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
        } catch (RuntimeException e){
            logger.error(e.getMessage());
            logger.error("Could not save the HTTP request - HTTP request may need restructuring");
            return new EmployeeDTO();
        }

        return new EmployeeDTO();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){

        try {
            logger.info("Deleting Employee ID " + id);
            employeeDAO.deleteById(id);


        } catch (NoSuchElementException e){
            logger.info(e.getMessage());

            logger.error("Employee ID " + id + " does not exist - Nothing deleted");

        }
    }

    @GetMapping("/")
    public List<Employee> findByLastName(@RequestParam String lastName){
        try {
            logger.info("Getting Employee by the last name of " + lastName);

            return employeeDAO.findEmployeeByLastName(lastName);

        } catch (NoSuchElementException e){
            logger.info(e.getMessage());

            logger.error("Employee by last name of " + lastName + " does not exist");
            return null;
        }

    }

}
