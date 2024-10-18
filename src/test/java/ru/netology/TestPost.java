package ru.netology;

import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TestPost {
    @Test
    void testPost() {

        String testData = "{\n" +
                "    \"name\": \"Имя\",\n" +
                "    \"patronymic\": \"Отчество\",\n" +
                "    \"surname\": \"Фамилия\",\n" +
                "    \"birthday\": \"1980-01-01\",\n" +
                "    \"passport\": 1111,\n" +
                "    \"phone\": \"+7 (999)-981-99-91\"\n" +
                "}";

        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body (testData)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("{\n" +
                        "    \"name\": \"Имя\",\n" +
                        "    \"patronymic\": \"Отчество\",\n" +
                        "    \"surname\": \"Фамилия\",\n" +
                        "    \"birthday\": \"1980-01-01\",\n" +
                        "    \"passport\": 1111,\n" +
                        "    \"phone\": \"+7 (999)-981-99-91\"\n" +
                        "}"))
                .body("data.passport", equalTo(1111));

    }
}
