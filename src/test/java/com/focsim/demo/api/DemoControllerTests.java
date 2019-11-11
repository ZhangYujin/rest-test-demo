package com.focsim.demo.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * @author zhangyujin
 * @createdOn 2019/11/9.
 */
@SpringBootTest
public class DemoControllerTests {


    @Test
    public void test() {
        get("/api/health").then().body("message", equalTo("success"));
    }


}
