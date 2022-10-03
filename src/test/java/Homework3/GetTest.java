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
import static io.restassured.RestAssured.responseSpecification;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;


public class GetTest extends AbstractTest {

    @Test
    void getEquipmentTest() {

        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("equipment", "blender")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch?equipment=blender")
                .then()
                .assertThat()
                .spec(responseSpecification);

    }

    @Test
    void getDietTest() {

        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("diet", "iron")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch?diet=iron")
                .then()
                .assertThat()
                .spec(responseSpecification);

    }

        @Test
    void getIncludeIngredientsTest() {

            JsonPath response = given()
                        .queryParam("apiKey", getApiKey())
                        .queryParam("includeIngredients", "cheese")
                        .when()
                        .get("https://api.spoonacular.com/recipes/complexSearch?includeIngredients=cheese")
                        .body()
                        .jsonPath();
                assertThat(response.get("totalResults"), equalTo(1305));
                assertThat(response.get("results[0].title"), equalTo("Greek-Style Baked Fish: Fresh, Simple, and Delicious"));


        }

    @Test
    void getExcludeIngredientsTest() {

        given().spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("excludeIngredients", "tomato")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch?excludeIngredients=tomato")
                .then()
                .assertThat()
                .header("Content-Length", Integer::parseInt, lessThan(3000))
                .body("results[0].title", equalTo("Cauliflower, Brown Rice, and Vegetable Fried Rice"));
    }

    @Test
    void getCuisineTest() {

        given().spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "chinese")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch?cuisine=chinese")
                .then()
                .assertThat()
                .body("results[2].title", equalTo("Mango Fried Rice"));
    }
    @Test
    void getTypeTest() {

        given().spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("type", "soup")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch?type=soup")
                .then()
                .assertThat()
                .body("results[9].title", equalTo("Moosewood Lentil Soup"))
                .body("totalResults", equalTo(320));
    }

    @Test
    void getSortTest() {

        given().spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("sort", "alcohol")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch?sort=alcohol")
                .then()
                .assertThat()
                .body("results[2].title", equalTo("Red-Wine Braised Short Ribs in a Dutch Oven"))
                .body("totalResults", equalTo(5225));
    }

    @Test
    void getAuthorTest() {

        given().spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("author", "coffeebean")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch?author=coffeebean")
                .then()
                .assertThat()
                .body("results[1].title", equalTo("Chickpea and Kale Minestrone Soup"))
                .body("totalResults", equalTo(159));
    }

    @Test
    void getTitleMatchTest() {

        given().spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("titleMatch", "Crock Pot")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch?titleMatch=Crock Pot")
                .then()
                .assertThat()
                .body("results[1].title", equalTo("Crockpot \"Refried\" Beans"))
                .body("totalResults", equalTo(20));
    }

    @Test
    void getMaxReadyTimeTest() {

        given().spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("maxReadyTime", "30")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch?maxReadyTime=30")
                .then()
                .assertThat()
                .header("Content-Length", Integer::parseInt, lessThan(3000))
                .body("totalResults", equalTo(507));
    }

    @Test
    void getIntolerancesTest() {

        given().spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("intolerances", "Seafood")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch?intolerances=Seafood")
                .then()
                .assertThat()
                .header("Content-Length", Integer::parseInt, lessThan(3000))
                .body("totalResults", equalTo(4680));
    }

    @Test
    void getMinCarbsTest() {

        given().spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("minCarbs", "20")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch?minCarbs=20")
                .then()
                .assertThat()
                .header("Content-Length", Integer::parseInt, lessThan(3000))
                .body("totalResults", equalTo(3208));
    }

    @Test
    void getMaxCarbsTest() {

        given().spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("maxCarbs", "100")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch?maxCarbs=100")
                .then()
                .assertThat()
                .header("Content-Length", Integer::parseInt, lessThan(3000))
                .body("totalResults", equalTo(4851));
    }
    @Test
    void getMinCaloriesTest() {

        given().spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("minCalories", "500")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch?minCalories=500")
                .then()
                .assertThat()
                .header("Content-Length", Integer::parseInt, lessThan(3000))
                .body("totalResults", equalTo(1224));
    }
    @Test
    void getMaxCaloriesTest() {

        given().spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("maxCalories", "1000")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch?maxCalories=1000")
                .then()
                .assertThat()
                .header("Content-Length", Integer::parseInt, lessThan(3000))
                .body("totalResults", equalTo(4925));
    }
    @Test
    void getMinFatTest() {

        given().spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("minFat", "5")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch?minFat=5")
                .then()
                .assertThat()
                .header("Content-Length", Integer::parseInt, lessThan(3000))
                .body("totalResults", equalTo(3990));
    }

    @Test
    void getMaxFatTest() {

        given().spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("maxFat", "100")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch?maxFat=100")
                .then()
                .assertThat()
                .header("Content-Length", Integer::parseInt, lessThan(3000))
                .body("totalResults", equalTo(4972));
    }
    @Test
    void getMinSugarTest() {

        given().spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("minSugar", "5")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch?minSugar=5")
                .then()
                .assertThat()
                .body("results[1].title", equalTo("African Chicken Peanut Stew"))
                .body("totalResults", equalTo(3246));
    }

    @Test
    void getMaxSugarTest() {

        given().spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("maxSugar", "2")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch?maxSugar=2")
                .then()
                .assertThat()
                .body("results[1].title", equalTo("Jade Buddha Salmon Tartare"))
                .body("totalResults", equalTo(749));
    }

    @Test
    void getMinZincTest() {

        given().spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("minZinc", "1")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch?minZinc=1")
                .then()
                .assertThat()
                .body("results[2].title", equalTo("Berry Banana Breakfast Smoothie"))
                .body("totalResults", equalTo(2602));

    }
    @Test
    void getMaxZincTest() {

        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("axZinc", "15")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch?maxZinc=15")
                .then()
                .spec(responseSpecification);

    }

}