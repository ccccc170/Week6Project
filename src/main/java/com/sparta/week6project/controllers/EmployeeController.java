package com.sparta.week6project.controllers;

import com.sparta.week6project.DAO.impl.EmployeeDAO;
import com.sparta.week6project.DTO.EmployeeDTO;
import com.sparta.week6project.entities.Employee;
import com.sparta.week6project.entities.User;
import com.sparta.week6project.repositories.UserRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/employees")

public class EmployeeController {
    @Autowired
    EmployeeDAO employeeDAO;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/{id}/{api}")
    public EmployeeDTO findByID(@PathVariable Integer id, @PathVariable String api ) throws AuthenticationException {
        UUID apiKey = UUID.fromString(api);
        User user = userRepository.findByApiKey(apiKey).get();


        if (user.getRole().equals("BASIC") || user.getRole().equals("UPDATE") || user.getRole().equals("ADMIN") ){

            return employeeDAO.findById(id).get();
    }
//       TODO: return an authentication error
        throw new AuthenticationException("Not authorised");

    }

    @PostMapping("/")
    public EmployeeDTO save(@RequestBody EmployeeDTO employeeDTO, @RequestBody String api) throws AuthenticationException {
        UUID apiKey = UUID.fromString(api);
        User user = userRepository.findByApiKey(apiKey).get();

        if (user.getRole().equals("UPDATE") || user.getRole().equals("ADMIN") ) {

            return employeeDAO.save(employeeDTO);
        }
//       TODO: return an authentication error
        throw new AuthenticationException("Not authorised");

    }

    @PatchMapping("/")
    public EmployeeDTO update(@RequestBody EmployeeDTO newEmployeeDTO, @RequestBody String api) throws AuthenticationException {
        UUID apiKey = UUID.fromString(api);
        User user = userRepository.findByApiKey(apiKey).get();

        if (user.getRole().equals("UPDATE") || user.getRole().equals("ADMIN") ) {


            Optional<EmployeeDTO> originalOptional = employeeDAO.findById(newEmployeeDTO.getId());
            EmployeeDTO original = null;
            if (originalOptional.isPresent()) {
                original = originalOptional.get();
                if (newEmployeeDTO.getFirstName() != null) {
                    original.setFirstName(newEmployeeDTO.getFirstName());
                }
                if (newEmployeeDTO.getLastName() != null) {
                    original.setLastName(newEmployeeDTO.getLastName());
                }
                if (newEmployeeDTO.getBirthDate() != null) {
                    original.setBirthDate(newEmployeeDTO.getBirthDate());
                }
                if (newEmployeeDTO.getHireDate() != null) {
                    original.setHireDate(newEmployeeDTO.getHireDate());
                }
                if (newEmployeeDTO.getGender() != null) {
                    original.setGender(newEmployeeDTO.getGender());
                }
                return employeeDAO.save(original);
            }
        }

//       TODO: return an authentication error
        throw new AuthenticationException("Not authorised");

    }

    @DeleteMapping("/{id}/{api}")
    public void deleteById(@PathVariable Integer id, @PathVariable String api ) throws AuthenticationException {
        UUID apiKey = UUID.fromString(api);
        User user = userRepository.findByApiKey(apiKey).get();

        if ( user.getRole().equals("ADMIN") ) {
            employeeDAO.deleteById(id);
        }
        throw new AuthenticationException("Not authorised");

    }

    @GetMapping("/")
    public List<Employee> findByLastName(@RequestParam String lastName, @RequestBody String api) throws AuthenticationException {
        UUID apiKey = UUID.fromString(api);
        User user = userRepository.findByApiKey(apiKey).get();

        if (user.getRole().equals("BASIC") || user.getRole().equals("UPDATE") || user.getRole().equals("ADMIN") ) {
            return employeeDAO.findEmployeeByLastName(lastName);
        }

//       TODO: return an authentication error
        throw new AuthenticationException("Not authorised");
    }

}
