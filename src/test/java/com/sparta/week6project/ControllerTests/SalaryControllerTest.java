package com.sparta.week6project.ControllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sparta.week6project.DAO.impl.SalaryDAO;
import com.sparta.week6project.DTO.SalaryDTO;
import com.sparta.week6project.entities.SalaryId;
import jakarta.transaction.Transactional;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.LocalDate;

public class SalaryControllerTest {

    @Test
    void testSaveSalary(){

        int salary = 25000;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/salaries/"))
                .timeout(Duration.ofMinutes(2))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{\n" +
                        "    \"id\": {\n" +
                        "        \"empNo\": 10,\n" +
                        "        \"fromDate\": \"2012-07-26\"\n" +
                        "    },\n" +
                        "    \"empNo\": 10,\n" +
                        "    \"salary\": "+ salary +",\n" +
                        "    \"toDate\": \"2020-12-15\"\n" +
                        "}")).build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        SalaryId salaryId = new SalaryId();
        salaryId.setEmpNo(10);
        salaryId.setFromDate(LocalDate.of(2012,07,26));
        String result = (response.body().split("\"salary\":")[1].split(",")[0]);

        Assertions.assertEquals(String.valueOf(salary),result);
    }

    @Test
    void testGetSalaryAverageByDepartmentAndDate(){
        ObjectMapper mapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();
        double result;
        try{
            result = mapper.readValue(new URL("http://localhost:8080/api/salaries/salaryAverage/?departmentNumber=d005&givenDate=2000-01-01"), double.class);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        System.out.println(result);
        Assertions.assertEquals(63193.0,result);


    }

    @Test
    void testGetSalaryRangeByTitleAndYear() {
        ObjectMapper mapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();
        JSONObject result;
        try{
            result = mapper.readValue(new URL("http://localhost:8080/api/salaries/salaryRange/?jobTitle=Engineer&givenYear=1989"), JSONObject.class);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        System.out.println(result);
        Assertions.assertEquals("103005 - 39177 = 63828",result.get("message"));
    }

    @Test
    void testGenderPayGapByDepartmentNumberAndYear(){
        ObjectMapper mapper = JsonMapper.builder().addModule(new JavaTimeModule()).build();
        JSONObject result;
        try{
            result = mapper.readValue(new URL("http://localhost:8080/api/salaries/salaryPayGap/?departmentNumber=d005&givenYear=9999-01-01"), JSONObject.class);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        System.out.println(result);
        Assertions.assertEquals("The women in d005 earn 3469.0 more!",result.get("message"));
    }
}
