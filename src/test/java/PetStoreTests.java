import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

@Feature("Pet Store API Tests")
public class PetStoreTests {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    @Description("Get pet by id")
    public void testGetById() {
        given()
        .pathParam("petId", 1)
        .when()
        .get("/pet/{petId}")
        .then()
        .statusCode(200)
        .contentType(ContentType.JSON)
        .body("id", Matchers.equalTo(1))
        .body("name", Matchers.equalTo("doggie"))
        .body("status", Matchers.equalTo("available"));
    }
}
