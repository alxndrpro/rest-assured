package restassured;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static restassured.ResponseSpecs.badEndpointSpec;

public class BadEndpointTest {

    static final String BAD_URL = "https://api.github.com/non/exsisting/url/";


    @Test
    public void testWithSpecOne() {
        RestAssured.get(BAD_URL)
                .then()
                .spec(badEndpointSpec())
                .body("message", equalTo("Not Found"));
    }

    @Test
    public void testWithSpecTwo() {
        RestAssured.get(BAD_URL)
                .then()
                .spec(badEndpointSpec())
                .body("documentation_url", equalTo("https://docs.github.com/rest"));
    }

}
