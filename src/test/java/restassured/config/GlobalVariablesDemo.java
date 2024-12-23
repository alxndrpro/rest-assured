package restassured.config;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class GlobalVariablesDemo {

    @BeforeSuite
    public void setup() {
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.basePath = "api/users";
        RestAssured.rootPath = "data";
    }

    @Test
    public void testOneUsingGlobalConstants() {
        RestAssured.get()
                .then()
                .body("id[0]", equalTo(1));
    }

    @Test
    public void testTwoUsingGlobalConstants() {
        RestAssured.get()
                .then()
                .body("id[1]", equalTo(2));
    }







}
