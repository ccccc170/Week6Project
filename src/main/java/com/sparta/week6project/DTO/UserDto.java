package com.sparta.week6project.DTO;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * A DTO for the {@link com.sparta.week6project.entities.User} entity
 */
@Data
public class UserDto implements Serializable {
    private final Long id;
    private final String email;
    private final UUID apiKey;
    private final Date apiExpiry;
    private final Integer role;
}