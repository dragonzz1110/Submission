package com.yourcompany.apod;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
public class ApodResourceTest {

    @Test
    public void testTodayEndpoint() {
        RestAssured.given()
                .when().get("/api/apod/today")
                .then()
                .statusCode(200)
                .body("title", notNullValue())
                .body("mediaUrl", notNullValue());
    }
}
