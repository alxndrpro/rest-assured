package restassured.body;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class ValidatableResponseRepeatingItemsDemo {

    public static final String USERS_EP = "https://reqres.in/api/users?page=1";


    @Test
    public void repeatingItems() {
        RestAssured.get(USERS_EP)
                .then()
                .body("data.id[0]", equalTo(1))
                .body("data.first_name[2]", equalTo("Emma"))
                .body("data.first_name[3]", equalTo("Eve"))
                .body("data.first_name", hasItems("Eve", "Emma"))
                .body("data.first_name", hasItem(endsWith("ma")));

    }

}
