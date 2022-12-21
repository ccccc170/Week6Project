package com.sparta.week5project;

import com.sparta.week5project.DAO.impl.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class Week5ProjectApplication {

    @Autowired
    private static EmployeeDAO employeeDAO;

    public static void main(String[] args) {

        SpringApplication.run(Week5ProjectApplication.class, args);

//        EmployeeDAO employeeDAO = new EmployeeDAO();
//        employeeDAO.deleteById(10001);
//        System.out.println(employeeDAO.findById(10002).get());
    }

}
