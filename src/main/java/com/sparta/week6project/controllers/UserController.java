package com.sparta.week6project.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.week6project.DAO.impl.UserDAO;
import com.sparta.week6project.DTO.DepartmentDTO;
import com.sparta.week6project.DTO.UserDTO;
import com.sparta.week6project.exceptions.KeyDoesNotExistException;
import com.sparta.week6project.repositories.ApikeyRepository;
import com.sun.net.httpserver.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ApikeyRepository apikeyRepository;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable Integer id) {
        return userDAO.findById(id).get();
    }

    @PostMapping()
    public ResponseEntity<String> save(@RequestBody UserDTO userDTO, @RequestParam String key) {
        HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.add("content-type", "application/json");
        ResponseEntity<String> response = null;
        try {
            response = new ResponseEntity<>(objectMapper.writeValueAsString(userDTO), headers, HttpStatus.OK);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        if(userDAO.isUpdateUser(key) || userDAO.isAdminUser(key) ) {
            userDAO.save(userDTO);
            return response;
        } else {
            response = new ResponseEntity<>("{\"message\":\"You are not authorized\"}", headers, HttpStatus.UNAUTHORIZED);
        }
         return  response;
    }


    @PutMapping("/")
    public UserDTO update(@RequestBody UserDTO userDTO) {
        Optional<UserDTO> originalOptional = userDAO.findById(userDTO.getId());
        if (originalOptional.isPresent()) {
            UserDTO original = originalOptional.get();
            if (userDTO.getFirstName() != null) {
                original.setFirstName(userDTO.getFirstName());
            }
            if (userDTO.getLastName() != null) {
                original.setLastName(userDTO.getLastName());
            }
            if (userDTO.getEmail() != null) {
                original.setEmail(userDTO.getEmail());
            }
            if (userDTO.getRole() != null) {
                original.setRole(userDTO.getRole());
            }

            return userDAO.save(original);
        }
        return new UserDTO();
    }

    @DeleteMapping("/")
    public void deleteById(@RequestParam Integer id) {
        userDAO.deleteById(id);
    }

    @GetMapping("/getApiKey/{email}")
    public String getApiKey(@PathVariable String email) {
        return userDAO.getApiKey(email);
    }

    @GetMapping("/getApiKey/regenerate/{email}")
    public String regenerateApiKey(@PathVariable String email) {
        return userDAO.regenerateApiKey(email);
    }

}
