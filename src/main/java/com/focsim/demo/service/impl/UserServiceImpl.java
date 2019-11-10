package com.focsim.demo.service.impl;

import com.focsim.demo.entity.User;
import com.focsim.demo.model.form.UserCreateForm;
import com.focsim.demo.model.form.UserUpdateForm;
import com.focsim.demo.repository.UserRepository;
import com.focsim.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户
 *
 * @author focsim
 * @date 2019/11/10 10:18 AM
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 查询用户
     *
     * @param id
     * @return
     */
    @Override
    public User findOne(int id) {
        return userRepository.getOne(id);
    }

    /**
     * 新建用户
     *
     * @param form
     * @return
     */
    @Override
    public User create(UserCreateForm form) {

        User user = new User(form.getName(), form.getGender(), form.getPassword());

        return userRepository.save(user);
    }

    /**
     * 更新用户
     *
     * @param form
     * @return
     */
    @Override
    public User update(UserUpdateForm form) {
        User user = new User(form.getName(), form.getGender(), form.getPassword());
        return userRepository.save(user);
    }
}
