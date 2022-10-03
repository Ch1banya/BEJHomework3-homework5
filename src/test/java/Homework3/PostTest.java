package Homework3;

import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;


public class PostTest extends AbstractTest {

    @Test
    void postTitleTestOne() {
                 given().spec(getRequestSpecification())
                         .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Bacon-Apple-Pecan Stuffed French Toast")
                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .body("cuisine", equalTo("American"));


    }
    @Test
    void postTitleTestTwo() {
        given().spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Sesame Flank Steak Salad")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .body("cuisine", equalTo("Mediterranean"));

    }
    @Test
    void postTitleTestThree() {
        given().spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Mushroom Jerky")
                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .body("cuisine", equalTo("Mediterranean"));

    }

    @Test
    void postTitleTestFour() {
        given().spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Scaloppine al Limone")
                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .body("cuisines[2]", equalTo("Italian"));
    }

    @Test
    void postTitleTestFive() {
        given().spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Chocolate Orange Cake")
                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .body("cuisines[2]", equalTo("Italian"));
    }

    @Test
    void postTitleTestSix() {
        given().spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Your Basic Low Carb Breakfast")
                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .body("cuisines[1]", equalTo("European"));
    }

    @Test
    void postTitleTestSeven() {
        given().spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Chorizo Parmesan Brussels Sprouts Skillet")
                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .body("cuisines[1]", equalTo("European"));
    }

    @Test
    void postTitleTestEight() {
        given().spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","6 Easy Last-Minute Seafood Dinner Ideas")
                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .body("cuisines[2]", equalTo("Italian"));
    }

    @Test
    void postTitleTestNine() {
        given().spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Don't Leave Home Without It: Homemade Beef Jerky to Take on Your Next Hike")
                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .body("cuisines[2]", equalTo("Italian"));
    }

    @Test
    void postIngredientTestOne() {
        given().spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("ingredientList","3 oz pork shoulder")
                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .body("cuisines[2]", equalTo("Italian"));
    }

    @Test
    void postIngredientTestTwo() {
        given().spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("ingredientList","potato")
                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .body("cuisines[1]", equalTo("European"));
    }

}
