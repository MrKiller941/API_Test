import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

@Feature("Pet Store API Tests")
public class UserTests {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    @Description("Create a new user")
    public void testCreateUser() {
        String username = "dima555";
        String userJson = "{"
            + "\"id\": 123,"
            + "\"username\": \"" + username + "\","
            + "\"firstName\": \"Test\","
            + "\"lastName\": \"User\","
            + "\"email\": \"testuser@example.com\","
            + "\"password\": \"password123\","
            + "\"phone\": \"1234567890\","
            + "\"userStatus\": 1"
            + "}";

        given()
            .contentType(ContentType.JSON)
            .body(userJson)
        .when()
            .post("/user")
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("code", Matchers.equalTo(200))
            .body("type", Matchers.equalTo("unknown"))
            .body("message", Matchers.notNullValue());
        // Дополнительная проверка для получения созданного пользователя и проверка его данных
        given()
            .pathParam("username", username)
        .when()
            .get("/user/{username}")
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("username", Matchers.equalTo(username))
            .body("email", Matchers.equalTo("testuser@example.com"));
    }
}