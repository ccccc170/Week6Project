package com.sparta.week6project.controllers;

import com.sparta.week6project.DAO.impl.UserDAO;
import com.sparta.week6project.DTO.DepartmentDTO;
import com.sparta.week6project.DTO.UserDTO;
import com.sparta.week6project.exceptions.KeyDoesNotExistException;
import com.sparta.week6project.repositories.ApikeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ApikeyRepository apikeyRepository;

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable Integer id) {
        return userDAO.findById(id).get();
    }

    @PostMapping()
    public UserDTO save(@RequestBody UserDTO userDTO) {
        return userDAO.save(userDTO);
    }

//    @PostMapping("/{key}")
//    public UserDTO save(@RequestBody UserDTO userDTO, @PathVariable String key) throws KeyDoesNotExistException {
//        if (apikeyRepository.findByApiKey(key).isPresent()) {
//            return userDAO.save(userDTO);
//        } else {
//            throw new KeyDoesNotExistException("Key is invalid");
//        }
//    }

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
