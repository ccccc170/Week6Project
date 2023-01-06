package com.sparta.week6project.mappers.impl;

import com.sparta.week6project.DTO.UserDTO;
import com.sparta.week6project.entities.User;
import com.sparta.week6project.mappers.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO userToDTO(User user) {
        if(user == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setRole(user.getRole());

        return userDTO;
    }

    @Override
    public User dtoToUser(UserDTO userDTO) {
        if(userDTO == null) {
            return null;
        }
        User user = new User();
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setRole(userDTO.getRole());


        return user;
    }
}
