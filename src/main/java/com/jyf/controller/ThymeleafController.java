package com.jyf.controller;

import com.jyf.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: yafu jiang
 * @Date: 2019/11/14 0014 17:17
 * @Description:
 */
@Controller
@RequestMapping("th")
public class ThymeleafController {
    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("name", "thymeleaf-imooc111");
        return "thymeleaf/index";
    }

    @RequestMapping("/main")
    public String main(ModelMap map) {
        map.addAttribute("name", "thymeleaf-imooc111");
        return "thymeleaf/main";
    }
    @RequestMapping("test")
    public String test(ModelMap map) {

        User u = new User();
        u.setName("jyf1");
        u.setPassword("123456");
        u.setAge(10);
        u.setBirthday(new Date());
        u.setDesc("<font color='green'><b>hello imooc</b></font>");

        map.addAttribute("user", u);

        User u1 = new User();
        u1.setName("jyf2");
        u1.setPassword("123456");
        u1.setAge(19);
        u1.setBirthday(new Date());

        User u2 = new User();
        u2.setAge(17);
        u2.setName("jyf3");
        u2.setPassword("123456");
        u2.setBirthday(new Date());

        List<User> userList = new ArrayList<>();
        userList.add(u);
        userList.add(u1);
        userList.add(u2);

        map.addAttribute("userList", userList);

        return "thymeleaf/test";
    }

    @RequestMapping("postform")
    public String postform(User user){
        System.out.println("user.getName() = " + user.getName());
        System.out.println("user.getName() = " + user.getAge());
        return "redirect:/th/test";
    }

    @RequestMapping("showerror")
    public String showerror(User u) {

        int a = 1 / 0;

        return "redirect:/th/test";
    }
}
