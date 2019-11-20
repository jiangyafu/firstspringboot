package com.jyf.controller;

import com.jyf.domain.Resource;
import com.jyf.domain.User;
import com.jyf.utils.JSONResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Auther: yafu jiang
 * @Date: 2019/11/14 0014 14:53
 * @Description:
 */
//@Controller
@RestController   //  @RestController  =  @Controller + @ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    private Resource resource;

    @RequestMapping("/getUser")
//    @ResponseBody
    public User getUser(){
        User user = new User();
        user.setName("jyf");
        user.setAge(18);
        user.setPassword("jyf password");
        user.setBirthday(new Date());
        user.setDesc("hello jyf");
        return user;
    }

    @RequestMapping("/getUserJson")
//    @ResponseBody
    public JSONResult getUserJson(){
        User user = new User();
        user.setName("jyf");
        user.setAge(18);
        user.setPassword("jyf password");
        user.setBirthday(new Date());
        user.setDesc("hello jyf ");
        return JSONResult.ok(user);
    }
}
