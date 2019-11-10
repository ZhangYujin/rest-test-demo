package com.focsim.demo.model.details;

import lombok.Data;

import java.util.Date;

/**
 * @author focsim
 * @date 2019/11/10 10:39 AM
 */
@Data
public class UserDetails {

    private int id;

    private String name;

    private String gender;

    private String password;

    private Date createdAt;

    private Date updatedAt;
}
