package com.sparta.week6project.ControllerTests;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sparta.week6project.DTO.DepartmentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class DepartmentControllerTest {
    @Test
    void testGetDepartment() {
        ObjectMapper mapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();
        DepartmentDTO result = null;

        try {
            result = mapper.readValue(new URL("http://localhost:8081/api/departments?dept_no=d009"), DepartmentDTO.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(result);
        Assertions.assertEquals(result.getDeptName(), "Customer Service");

    }

    @Test
    public void testPostDepartment() throws Exception {
        ObjectMapper mapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();
        HttpClient client = HttpClient.newHttpClient();


        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId("d000");
        departmentDTO.setDeptName("My New Department");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8081/api/departments/"))
                .timeout(Duration.ofMinutes(2))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(mapper.writeValueAsString(departmentDTO)))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
        DepartmentDTO result = null;

        try {
            result = mapper.readValue(new URL("http://localhost:8081/api/departments?dept_no=d000"), DepartmentDTO.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals(result.getDeptName(), "My New Department");
    }

    @Test
    public void testDeleteDepartment() throws Exception {
        ObjectMapper mapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8081/api/departments/?id=d000"))
                .timeout(Duration.ofMinutes(2))
                .header("Content-Type", "application/json")
                .DELETE().build();
        ;
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());

        Assertions.assertEquals(response.body(), "");

    }

    @Test
    public void testPutDepartment() throws Exception {
        ObjectMapper mapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();
        HttpClient client = HttpClient.newHttpClient();

        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId("d007");
        departmentDTO.setDeptName("Sales changed");


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8081/api/departments/"))
                .timeout(Duration.ofMinutes(2))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(mapper.writeValueAsString(departmentDTO)))
                .build();
        ;
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());

        DepartmentDTO result = null;

        try {
            result = mapper.readValue(new URL("http://localhost:8081/api/departments?dept_no=d014"), DepartmentDTO.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals(result.getDeptName(), "Test Department");

    }
}
