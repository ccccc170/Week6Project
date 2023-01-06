package com.sparta.week6project.mappers;

import com.sparta.week6project.DTO.UserDTO;
import com.sparta.week6project.entities.User;

public interface UserMapper {

    UserDTO userToDTO(User user);
    User dtoToUser(UserDTO userDTO);
}
