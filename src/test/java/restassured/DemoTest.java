package restassured;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class DemoTest {

    @Test
    void firstTest() {
        RestAssured.get("https://api.github.com")
                .then()
                .statusCode(200);
    }

}
