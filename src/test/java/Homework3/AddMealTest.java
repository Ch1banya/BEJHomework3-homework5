package Homework3;

import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.lessThan;


public class AddMealTest extends AbstractTest {

    String id;

    @Test
    void addDelMealTestOne() {
        id = given().spec(requestSpecification)
                .queryParam("hash", "97cdc26661d7df6212f98ed873419bbe6224fa39")
                .queryParam("apiKey", getApiKey())
                .body("{\"item\": \"1 package baking powder\", \"aisle\": \"Baking\", \"parse\": true}")
                .when()
                .post(getPostUrl())
                .then()
                .body("name", equalTo("baking powder"))
                .extract()
                .jsonPath()
                .get("id")
                .toString();

        given()
                .queryParam("hash", "97cdc26661d7df6212f98ed873419bbe6224fa39")
                .queryParam("apiKey", getApiKey())
                .delete(getDeleteUrl() + id)
                .then()
                //Проверяю на успешное удаление из списка
                .body("status", equalTo("success"));


        //       .statusCode(200);
    }

    // Вариант теста с использованием tearDown
    @Test
    void addDelMealTestTwo() {
        id = given().spec(requestSpecification)
                .queryParam("hash", "97cdc26661d7df6212f98ed873419bbe6224fa39")
                .queryParam("apiKey", getApiKey())
                .body("{\"item\": \"1 package baking powder\", \"aisle\": \"Baking\", \"parse\": true}")
                .when()
                .post(getPostUrl())
                .then()
                .body("name", equalTo("baking powder"))
                .extract()
                .jsonPath()
                .get("id")
                .toString();

    }

    @AfterEach
    void tearDown() {
        given()
                .queryParam("hash", "97cdc26661d7df6212f98ed873419bbe6224fa39")
                .queryParam("apiKey", getApiKey())
                .delete(getDeleteUrl() + id)
                .then()
                .statusCode(200);


    }
}