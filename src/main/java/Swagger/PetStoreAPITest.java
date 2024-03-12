package Swagger;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PetStoreAPITest {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test(priority = 0)
    public void testPost() {
        String newPetName = "Hello_World";
        String petId = "1";
        String newPetStatus = "имеется";
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"name\": \"" + newPetName + "\", \"status\": \"" + newPetStatus + "\", \"id\": \""+ petId+"\"}")
                .when()
                .post("/pet")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test(priority = 1)
    public void testGet() {
        int petId = 1;
        given()
                .log().all()
                .pathParam("petId", petId)
                .when()
                .get("/pet/{petId}")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test(priority = 2)
    public void testPut() {
        String username = "Anton";
        String email = "Test@mail.ru";
        given()
                .contentType(ContentType.JSON)
                .pathParam("username", username)
                .body("{ \"username\": \"" + username + "\", \"email\": \"" + email + "\", \"phone\": \"123456789\", \"userStatus\": 1 }")
                .when()
                .put("user/{username}")
                .then()
                .log().all()
                .statusCode(200);
    }

        @Test(priority = 3)
        public void testDelete() {
            int petId = 1;
            given()
                    .log().all()
                    .pathParam("petId", petId)
                    .when()
                    .delete("/pet/{petId}")
                    .then()
                    .log().all()
                    .statusCode(200);
        }
    }

