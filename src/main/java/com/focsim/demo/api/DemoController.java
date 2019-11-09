package com.focsim.demo.api;

import com.focsim.demo.model.details.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangyujin
 * @createdOn 2019/11/2.
 */
@RestController
public class DemoController {

    @GetMapping("/api/health")
    public Result getHealth() {
        return new Result(0, "success");
    }


}
