package controllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sparta.week6project.DTO.DeptManagerDTO;
import com.sparta.week6project.entities.DeptManagerId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class DeptManagerControllerTest {
    @Test
    void testGetDepartmentManager() throws Exception{
        ObjectMapper mapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();
        DeptManagerDTO result = null;

        try{
            result = mapper.readValue(new URL("http://localhost:8080/api/departmentManager/?empNo=110022&deptNo=d001"), DeptManagerDTO.class);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        System.out.println(result);
    }


}
