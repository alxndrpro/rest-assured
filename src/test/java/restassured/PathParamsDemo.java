package restassured;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import java.util.Map;

public class PathParamsDemo {

    static final String REPO_EP = "https://api.github.com/repos";
    static final String USER_PS = "alxndrpro";

    @Test
    void withoutParamHardcoded() {
        RestAssured.get(REPO_EP + "/{user}/{repo}", USER_PS, "rest-assured")
                .then()
                .statusCode(200)
                .body("id", equalTo(882699996));
    }

    @Test
    void withOverloadedGet() {
        RestAssured.get(REPO_EP + "/{user}/{repo}", USER_PS, "java")
                .then()
                .statusCode(200)
                .body("id", equalTo(693109904));
    }

    @Test
    void withParam() {
        RestAssured
                .given()
                .pathParam("user", USER_PS)
                .pathParam("repo", "pw-practice-app")
                .get(REPO_EP + "/{user}/{repo}")
                .then()
                .statusCode(200)
                .body("id", equalTo(875634828));
    }

    @Test
    void withParamAsMap() {

        Map<String, String> reusableMap = Map.of("user", USER_PS, "repo", "pw-practice-app");

        RestAssured
                .given()
                .pathParams(reusableMap)
                .get(REPO_EP + "/{user}/{repo}")
                .then()
                .statusCode(200)
                .body("id", equalTo(875634828));
    }


}
