package com.jyf.controller;

import com.jyf.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.expression.Lists;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller()
@RequestMapping("/th")
public class ThymeleafController {
    @RequestMapping("/index")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("name","hello ThymeleafController");
        return "thymeleaf/index";
    }
    @RequestMapping("/center")
    public String center(){
        return "thymeleaf/center/center";
    }

    @RequestMapping("/test")
    public String test(ModelMap modelMap){

        User user1 = new User();
        user1.setName("superadmin");
        user1.setAge(18);
        user1.setBirthday(new Date());
        user1.setDesc("<font color='green'><b>hello jyf</b></font>");
        modelMap.addAttribute("user",user1);

        User user2 = new User();
        user2.setName("jyf2");
        user2.setAge(19);
        user2.setBirthday(new Date());

        User user3 = new User();
        user3.setName("jyf3");
        user3.setAge(17);
        user3.setBirthday(new Date());

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        modelMap.addAttribute("userList",userList);
        return "thymeleaf/test";
    }

    @RequestMapping("/postForm")
    public String postForm(User user){
        System.out.println("user.getName() = " + user.getName());
        System.out.println("user.getAge() = " + user.getAge());
        return "redirect:/th/test";
    }


}
