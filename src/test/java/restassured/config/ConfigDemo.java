package restassured.config;

import io.restassured.RestAssured;
import io.restassured.config.FailureConfig;
import io.restassured.listener.ResponseValidationFailureListener;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class ConfigDemo {

    static final String BASE_URL = "https://api.github.com/";

    @Test
    void maxRedirectsTest() {

//        RestAssured.config = RestAssured.config().redirect(RedirectConfig.redirectConfig().followRedirects(true).maxRedirects(0));

        RestAssured.get(BASE_URL + "repos/twitter/bootstrap")
                .then()
                .statusCode(equalTo(200));
    }


    @Test
    void failureConfigExample() {

        ResponseValidationFailureListener failureListener = (reqSpec, resSpec, response) ->
                System.out.printf("We have a failure, " +
                                "response status was %s and the body contained: %s",
                        response.getStatusCode(), response.body().asPrettyString());

        RestAssured.config = RestAssured.config().failureConfig(FailureConfig.failureConfig().failureListeners(failureListener));

        RestAssured.get(BASE_URL + "users/alxndr.pro")
                .then()
                .body("some.path", equalTo("smth"))
                .statusCode(equalTo(200));
    }


}
