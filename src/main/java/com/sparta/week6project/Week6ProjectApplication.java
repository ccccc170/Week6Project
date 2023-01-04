package com.sparta.week6project;

import com.sparta.week6project.DAO.impl.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Week6ProjectApplication {

    @Autowired
    private static EmployeeDAO employeeDAO;

    public static void main(String[] args) {

        SpringApplication.run(Week6ProjectApplication.class, args);

    }

}
