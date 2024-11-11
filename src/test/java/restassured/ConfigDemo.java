package restassured;

import io.restassured.RestAssured;
import io.restassured.config.RedirectConfig;
import io.restassured.config.RestAssuredConfig;
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



}
