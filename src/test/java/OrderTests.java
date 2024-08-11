import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

@Feature("Pet Store API Tests")
public class OrderTests {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    @Description("Create a new order in the store")
    public void testCreateOrder() {
        String orderJson = "{"
            + "\"id\": 10,"
            + "\"petId\": 198772,"
            + "\"quantity\": 1,"
            + "\"shipDate\": \"2024-09-08T10:00:00.000Z\","
            + "\"status\": \"placed\","
            + "\"complete\": true"
            + "}";

        given()
            .contentType(ContentType.JSON)
            .body(orderJson)
        .when()
            .post("/store/order")
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("id", Matchers.equalTo(10))
            .body("petId", Matchers.equalTo(198772))
            .body("quantity", Matchers.equalTo(1))
            .body("shipDate", Matchers.equalTo("2024-09-08T10:00:00.000+0000"))
            .body("status", Matchers.equalTo("placed"))
            .body("complete", Matchers.equalTo(true));
    }
}