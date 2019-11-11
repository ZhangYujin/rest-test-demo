package com.focsim.demo.api;

import com.focsim.demo.entity.User;
import com.focsim.demo.model.details.UserDetails;
import com.focsim.demo.model.form.UserCreateForm;
import com.focsim.demo.service.UserService;
import com.focsim.demo.utils.DtoUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;

/**
 * @author focsim
 * @date 2019/11/10 10:30 AM
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 查询ID
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public UserDetails findOne(@PathVariable(name = "id") int id) {

        UserDetails userDetails = new UserDetails();
        User user = userService.findOne(id);
        if (user != null) {
            DtoUtils.mapTo(user, userDetails, true);
        }


        return userDetails;
    }


    /**
     * 新建用户
     *
     * @param form
     * @param result
     * @return
     */
    @PostMapping
    public UserDetails create(@RequestBody @Valid UserCreateForm form, BindingResult result) {
        if (result.hasErrors()) {
            throw new ValidationException("Param Invalid");
        }

        User user = userService.create(form);
        UserDetails userDetails = DtoUtils.map(user, UserDetails.class, true);

        return userDetails;
    }


}
