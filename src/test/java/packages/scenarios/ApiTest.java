package packages.scenarios;


import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static packages.utils.PropertyNames.ENDPOINT_COUNTRY_SERVICE;
import static packages.utils.TestGroups.API;

public class ApiTest extends ApiTestBase {

    @Test(groups = {API}, description = "API json test")
    public void testEchoService() {
        String key = "foo";
        String value = "bar";
        given()
                .when()
                .spec(getSpecification())
                .get(String.format("http://echo.jsontest.com/%s/%s", key, value))
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body(key, equalTo(value));
    }

    @Test(groups = {API}, description = "API Country service test")
    void testCountryService() {
        given()
                .spec(getSpecification())
                .when()
                .get(ENDPOINT_COUNTRY_SERVICE)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("RestResponse.result.name", equalTo("Spain"));
    }
}
