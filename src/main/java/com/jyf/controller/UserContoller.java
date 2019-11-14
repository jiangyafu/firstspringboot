package com.jyf.controller;

import com.jyf.domain.User;
import com.jyf.utils.JSONResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Auther: yafu jiang
 * @Date: 2019/11/14 0014 16:52
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserContoller {

    @RequestMapping("/getUser")
    public User getUser() {
        User u = new User();
        u.setName("jyf1");
        u.setAge(18);
        u.setBirthday(new Date());
        u.setPassword("jyf");
        u.setDesc("hello jyf~~");
        return u;
    }

    @RequestMapping("/getUserJson")
    public JSONResult getUserJson(){
        User u = new User();
        u.setName("jyf1");
        u.setAge(18);
        u.setBirthday(new Date());
//        u.setPassword("jyf");
//        u.setDesc("hello jyf~~");
        return JSONResult.ok(u);

    }
}
