package restassured;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class DefaultParserDemo {

    public final String BASE_URL = "https://api.github.com";

    @Test
    public void parserAndSyntaticSugar() {
        RestAssured.get(BASE_URL)
                .then()
                .using()
                .defaultParser(Parser.XML)
                .body("current_user_url", equalTo(BASE_URL + "user"));
    }

}
