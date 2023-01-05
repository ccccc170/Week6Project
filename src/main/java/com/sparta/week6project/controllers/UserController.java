package com.sparta.week6project.controllers;

import com.sparta.week6project.entities.User;
import com.sparta.week6project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")

public class UserController {

    @Autowired
    UserRepository userDAO;

    @GetMapping("/{email}")
    public User getAPIKey(@PathVariable String email){
        return userDAO.findByEmail(email).get();
    }

    @GetMapping("/setup")
    public void setup(){
        User admin = new User();
        admin.setEmail("admin@example.com");
        admin.setApiKey(new UUID(new Random().nextInt(), new Random().nextInt()));
        admin.setApiExpiry(Date.from(Instant.now().plusMillis(604800)));
        admin.setRole(100);
        userDAO.save(admin);

        User updateUser = new User();
        updateUser.setEmail("CRU@example.com");
        updateUser.setApiKey(new UUID(new Random().nextInt(), new Random().nextInt()));
        updateUser.setApiExpiry(Date.from(Instant.now().plusMillis(604800)));
        updateUser.setRole(10);
        userDAO.save(updateUser);

        User user = new User();
        user.setEmail("basic-user@example.com");
        user.setApiKey(new UUID( new Random().nextInt(), new Random().nextInt()));
        user.setApiExpiry(Date.from(Instant.now().plusMillis(604800)));
        user.setRole(1);
        userDAO.save(user);

        User unAuthUser = new User();
        unAuthUser.setEmail("no-access@example.com");
        unAuthUser.setApiKey(new UUID( new Random().nextInt(), new Random().nextInt()));
        unAuthUser.setApiExpiry(Date.from(Instant.now().plusMillis(604800)));
        unAuthUser.setRole(-1);
        userDAO.save(unAuthUser);
    }

}
