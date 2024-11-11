package restassured.params;

import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class ParametrizedTestDemo {
    static final String SEARCH_EP = "https://api.github.com/search/repositories";

    @DataProvider
    public Object[][] queryParams() {
        return new Object[][]{
                {Map.of("q", "java", "per_page", "1"), 1},
                {Map.of("q", "python", "per_page", "2"), 2},
                {Map.of("q", "C3", "per_page", "5"), 5}
        };
    }

    @Test(dataProvider = "queryParams")
    void dataDrivenTest(Map<String, String> params, int expectedRepoCount) {
        var json =
                RestAssured
                        .given()
                        .params(params)
                        .get(SEARCH_EP).jsonPath();


        Assert.assertEquals(json.getInt("items.size()"), expectedRepoCount);

    }


}
