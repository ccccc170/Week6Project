package com.sparta.week6project.ControllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

public class SalaryControllerTest {

    @Test
    void testGetSalary(){
        ObjectMapper mapper = JsonMapper.builder().addModule(new JavaTimeModule()).build();

    }
}
