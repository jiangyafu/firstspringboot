package com.jyf.controller;


import com.jyf.domain.SysUser;
import com.jyf.service.UserService;
import com.jyf.utils.JSONResult;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/mybatis")
public class MybatisCrudController {

    @Autowired
    private UserService userService;

    @Autowired
    private Sid sid;

    @RequestMapping("/saveUser")
    public JSONResult save(){
        String s = sid.nextShort();
        SysUser user = new SysUser();
        user.setId(s);
        user.setUsername("jyf");
        user.setNickname("简单");
        user.setPassword("abc123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());
        userService.save(user);
        return JSONResult.ok("保存成功");

    }

    @RequestMapping("/updateUser")
    public JSONResult updateUser(){
        SysUser sysUser = new SysUser();
        sysUser.setId("191118HHM8YKF23C");
        sysUser.setUsername("jyf1"+new Date());
        sysUser.setNickname("简单1");
        sysUser.setPassword("jjjj");
        sysUser.setIsDelete(0);
        sysUser.setRegistTime(new Date());
        userService.update(sysUser);
        return JSONResult.ok("保存成功");
    }

    @RequestMapping("/queryUserListPaged")
    public JSONResult queryUserListPaged(Integer page){
        if(page == null){
            page = 1;
        }
        int pageSize = 2;
        SysUser sysUser = new SysUser();
//        sysUser.setNickname("jyf");
        List<SysUser> userList = userService.queryUserListPaged(sysUser, page, pageSize);
        return JSONResult.ok(userList);
    }

    @RequestMapping("/queryUserByIdCustom")
    public JSONResult queryUserByIdCustom(String id){
        SysUser sysUser = userService.queryUserSimplyInfoById(id);
        return JSONResult.ok(sysUser);
    }

}
