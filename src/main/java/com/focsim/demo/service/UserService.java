package com.focsim.demo.service;

import com.focsim.demo.entity.User;
import com.focsim.demo.model.form.UserCreateForm;
import com.focsim.demo.model.form.UserUpdateForm;

/**
 * @author focsim
 * @date 2019/11/10 10:17 AM
 */
public interface UserService {


    User findOne(int id);

    User create(UserCreateForm form);

    User update(UserUpdateForm form);

}
