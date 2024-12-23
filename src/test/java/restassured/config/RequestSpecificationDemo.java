package restassured.config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class RequestSpecificationDemo {

    static final String BASE_URL = "https://api.github.com/";
    static RequestSpecification spec = new RequestSpecBuilder().setBaseUri(BASE_URL).build();


    @Test
    void testUsingLocalRequestSpec() {
        RestAssured
                .given()
                .spec(spec)
                .when()
                .get()
                .then()
                .statusCode(200);
    }


}
