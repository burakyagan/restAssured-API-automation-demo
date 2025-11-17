package com.trendyol.tests;

import com.trendyol.base.ApiBaseTest;
import com.trendyol.constants.ApiEndpoints;
import com.trendyol.pojos.UserGetResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

public class ListUser extends ApiBaseTest {

    @Test
    @DisplayName("List User Successfully (GET)")
    public void listUserSuccessfully() {
        // test verisi hazırlamıyoruz çünkü Request POJO sınıfımız yok. Burada direkt int değişkenleri vererek parametreleri söylüyoruz
        int page = 2;

        // restAssured ile API isteği
        UserGetResponse userGetResponse =
                given()
                        .spec(spec)
                        .queryParam("page", page)

                        .when()
                        .get(ApiEndpoints.USERS)

                        .then()
                        .spec(ResponseSpec200)
                        .extract().as(UserGetResponse.class);

        // assert doğrulaması (POJO ile)
        assertEquals(page, userGetResponse.getPage());
        assertNotNull(userGetResponse.getData());
        assertFalse(userGetResponse.getData().isEmpty());
        assertEquals(6, userGetResponse.getData().size());


    }

    @ParameterizedTest
    @DisplayName("User Data From CSV File")
    @CsvFileSource(resources = "/testdata/user_data.csv", numLinesToSkip = 1)
    public void getUserDataWithCsv(int id, String expectedName){

        given()
                .spec(spec)
                .pathParam("id", id)
                .when()
                .get(ApiEndpoints.USER_BY_ID)
                .then()
                .spec(ResponseSpec200)
                .body("data.first_name", equalTo(expectedName));


    }

    @Test
    @DisplayName("Negative Case - Nonexistent User Should Return 404")
    public void getNonexistentUserReturns404() {
        int nonExistingUserId = 50;

        given()
                .spec(spec)
                .pathParam("id", nonExistingUserId)
                .when()
                .get(ApiEndpoints.USER_BY_ID)
                .then()
                .statusCode(404);
    }

    @Test
    @DisplayName("Negative Case - Invalid Endpoint Should Return 404")
    public void invalidEndpointReturns404() {
        given()
                .spec(spec)
                .when()
                .get(ApiEndpoints.USERS + "/invalidEndpoint")
                .then()
                .statusCode(404);
    }

}