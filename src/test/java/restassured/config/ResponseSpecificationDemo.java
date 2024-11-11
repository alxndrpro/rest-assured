package restassured.config;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ResponseSpecificationDemo {

    static final String BASE_URL = "https://api.github.com/";

    @BeforeClass
    void setup() {
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(404)
                .expectContentType(ContentType.JSON)
                .build();
    }

    @AfterClass
    void cleanup() {
        RestAssured.responseSpecification = null;
    }


    @Test
    void testWithSpecOne() {
        RestAssured.get(BASE_URL + "non/existing/url");
    }

    @Test
    void testWithSpecTwo() {
        RestAssured.get(BASE_URL + "non/existing/url");
    }


}
