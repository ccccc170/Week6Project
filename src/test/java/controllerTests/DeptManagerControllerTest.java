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
        Assertions.assertEquals(110022, result.getEmpNo());
        Assertions.assertEquals("d001", result.getDeptNo());
    }
    @Test
    void testCreateDepartmentManager(){
        HttpRequest request = HttpRequest.newBuilder()
                .uri((URI.create("http://localhost:8080/api/departmentManager/")))
                .timeout(Duration.ofMinutes(2))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(
                        "{\n" +
                                "    \"empNo\": 110022,\n" +
                                "    \"deptNo\": \"d005\",\n" +
                                "    \"fromDate\": \"2023-01-05\",\n" +
                                "    \"toDate\": \"2025-10-02\"\n" +
                                "}"
                )).build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response;
        try{
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
        DeptManagerId deptManagerId = new DeptManagerId();
        deptManagerId.setDeptNo("d003");
        deptManagerId.setEmpNo(110022);

        System.out.println(response.body());
        System.out.println(response.statusCode());
        Assertions.assertEquals(200, response.statusCode());

    }

    @Test
    void testDeleteDepartmentManager() throws IOException, InterruptedException {
        ObjectMapper mapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/departmentManager/?empNo=110022&deptNo=d004"))
                .timeout(Duration.ofMinutes(2))
                .header("Content-Type", "application/json")
                .DELETE().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
        Assertions.assertEquals(200, response.statusCode());

    }

}
