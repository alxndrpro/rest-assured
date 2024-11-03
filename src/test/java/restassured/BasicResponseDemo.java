package restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class BasicResponseDemo {

    static final String BASE_URL = "https://api.github.com";

    @Test
    void convenienceMethods() {
        Response response = RestAssured.get(BASE_URL);
        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.getContentType(), "application/json; charset=utf-8");
    }

    @Test
    void genericHeader() {
        Response response = RestAssured.get(BASE_URL);
        assertEquals(response.getHeader("server"), "github.com");
        assertEquals(response.getHeader("x-ratelimit-limit"), "60");
    }

}
