package com.focsim.demo.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

/**
 * @author zhangyujin
 * @createdOn 2019/11/9.
 */
@SpringBootTest
public class DemoControllerTests {

    @Test
    public void test() {
        RestAssured.get("/api/health").then().body("message", equalTo("success"));
    }

}
