package com.focsim.demo.model.details;

import lombok.Data;

/**
 * 结果
 *
 * @author zhangyujin
 * @createdOn 2019/11/9.
 */
@Data
public class Result {

    public int status;

    public String message;

    public Result(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
