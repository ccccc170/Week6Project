package com.sparta.week6project.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private Integer id;

    private String email;

    private String firstName;

    private String lastName;

    private String role;



}
