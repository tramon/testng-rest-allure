package packages.scenarios;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.Cookies;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;


import java.util.Optional;

import static packages.utils.PropertyNames.API_URL;


public abstract class ApiTestBase {

    @Getter
    private RequestSpecification specification;

    private Cookies currentCookies;

    ApiTestBase() {
//        PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
//        auth.setUserName("userLogin");
//        auth.setPassword("userPass");
        specification = new RequestSpecBuilder()
//                .setAuth(auth)
                .setBaseUri(API_URL)
//                .setContentType("application/json; charset=UTF-8")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    Cookies getCurrentCookies() {
        return Optional.ofNullable(currentCookies).orElseThrow(() -> new NullPointerException("Cookies were not yet created"));
    }
}
