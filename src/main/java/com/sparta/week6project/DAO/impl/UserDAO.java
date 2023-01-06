package com.sparta.week6project.DAO.impl;

import com.sparta.week6project.DAO.interfaces.UserService;
import com.sparta.week6project.DTO.UserDTO;
import com.sparta.week6project.entities.Apikey;
import com.sparta.week6project.entities.User;
import com.sparta.week6project.mappers.impl.UserMapperImpl;
import com.sparta.week6project.repositories.ApikeyRepository;
import com.sparta.week6project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserDAO implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapperImpl userMapper;

    @Autowired
    ApikeyRepository apikeyRepository;


    public UserDTO save(UserDTO user) {
        return userMapper.userToDTO(userRepository.save(userMapper.dtoToUser(user)));
    }

    public Optional<UserDTO> findById(Integer id) {
        return Optional.of(userMapper.userToDTO(userRepository.findById(id).get()));
    }

    public void update(UserDTO user, Integer id) {
        Optional<User> userDb = userRepository.findById(id);
        if (userDb.isPresent()) {
            User existingUser = userDb.get();
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            existingUser.setRole(user.getRole());

            userRepository.save(existingUser);
        }
    }


    public void deleteById(Integer id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        }
    }


    @Override
    public String getApiKey(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            String key = UUID.randomUUID().toString() + System.currentTimeMillis();
            Apikey apikey = Apikey.builder()
                    .apiKey(key)
                    .isNew(true)
                    .email(email)
                    .lastUpdate(Instant.from(LocalDateTime.now()))
                    .build();
//            check if api needs id in builder?
            Apikey apikeySaved = apikeyRepository.save(key);
            return key;
        }
        return null;
    }

    public String regenerateApiKey(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            Optional<Apikey> apiByEmail = apikeyRepository.findByEmail(email);
            Apikey apiKey = apiByEmail.get();
            List<Apikey> allByEmail = apikeyRepository.findAllByEmail(email);
            allByEmail.stream()
                    .filter(a -> Boolean.parseBoolean(a.getApiKey()))
                    .forEach(a -> a.setIsNew(false));
            String key = UUID.randomUUID().toString() + System.currentTimeMillis();
            Apikey apikey = Apikey.builder()
                    .apiKey(key)
                    .isNew(true)
                    .email(email)
                    .lastUpdate(Instant.from(LocalDateTime.now()))
                    .build();
//            check if api needs id in builder?
            Apikey apikeySaved = apikeyRepository.save(key);
            return key;
        }
        return null;
    }

}
