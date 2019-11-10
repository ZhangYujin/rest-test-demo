package com.focsim.demo.model.form;

import lombok.Data;

/**
 * 用户更新
 *
 * @author focsim
 * @date 2019/11/10 10:42 AM
 */
@Data
public class UserUpdateForm {

    private String name;

    private String gender;

    private String password;
}
