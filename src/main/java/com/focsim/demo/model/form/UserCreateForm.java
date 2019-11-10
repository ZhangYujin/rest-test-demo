package com.focsim.demo.model.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 用户创建
 *
 * @author focsim
 * @date 2019/11/10 10:41 AM
 */
@Data
public class UserCreateForm {

    @NotNull
    private String name;

    @NotNull
    private String gender;

    @NotNull
    private String password;

}
