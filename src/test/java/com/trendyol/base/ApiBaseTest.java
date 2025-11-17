package com.trendyol.base;

import com.trendyol.utils.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

public abstract class ApiBaseTest {

    protected static RequestSpecification spec;
    protected static ResponseSpecification ResponseSpec200;
    protected static ResponseSpecification ResponseSpec201;
    protected static ResponseSpecification ResponseSpec400;

    @BeforeAll
    static void setup() {

        spec = new RequestSpecBuilder()
                .setBaseUri(ConfigReader.getBaseUri())
                .setContentType(ContentType.JSON)
                .addHeader("x-api-key", ConfigReader.getApiKey())
                .build();

        ResponseSpec200 = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();

        ResponseSpec201 =new ResponseSpecBuilder()
                .expectStatusCode(201)
                .expectContentType(ContentType.JSON)
                .build();

        ResponseSpec400 =new ResponseSpecBuilder()
                .expectStatusCode(400)
                .expectContentType(ContentType.JSON)
                .build();
    }
}
