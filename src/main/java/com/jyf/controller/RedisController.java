package com.jyf.controller;

import com.jyf.domain.SysUser;
import com.jyf.domain.User;
import com.jyf.domain.JSONResult;
import com.jyf.utils.JsonUtils;
import com.jyf.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate strRedis;

    @Autowired
    private RedisOperator redis;

    @RequestMapping("/test")
    public JSONResult test(){
//        strRedis.opsForValue().set("name","jyf");
//        return JSONResult.ok(strRedis.opsForValue().get("name"));
        SysUser sysUser = new SysUser();
        sysUser.setId("10010");
        sysUser.setUsername("jyf");
        sysUser.setNickname("j简单");
        sysUser.setRegistTime(new Date());
        strRedis.opsForValue().set("json:user",JsonUtils.objectToJson(sysUser));
        return JSONResult.ok(JsonUtils.jsonToPojo(strRedis.opsForValue().get("json:user"),sysUser.getClass()));
    }

    @RequestMapping("/getJsonList")
    public JSONResult getJsonList(){
        User user1 = new User();
        user1.setName("jyf");
        user1.setAge(18);
        user1.setPassword("asd");
        user1.setBirthday(new Date());

        User user2 = new User();
        user2.setName("yfj");
        user2.setAge(16);
        user2.setPassword("fgh");
        user2.setBirthday(new Date());

        User user3 = new User();
        user3.setName("zxc");
        user3.setAge(18);
        user3.setPassword("jkl");
        user3.setBirthday(new Date());

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        redis.set("json:info:userList",JsonUtils.objectToJson(userList));
        String s = redis.get("json:info:userList");
        List<User> userList1 = JsonUtils.jsonToList(s, User.class);
        return JSONResult.ok(userList1);
    }


}
