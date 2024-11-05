package restassured;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class HeadAndOptionsDemo {

    static final String BASE_URL = "https://api.github.com";

    @Test
    public void headTest() {
        RestAssured.head(BASE_URL)
                .then()
                .statusCode(200)
                .body(emptyOrNullString());
    }


    @Test
    public void optionsTest() {
        RestAssured.options(BASE_URL)
                .then()
                .statusCode(200)
                .header("access-control-allow-methods",equalTo("GET, POST, PATCH, PUT, DELETE"))
                .body(emptyOrNullString());
    }

}
