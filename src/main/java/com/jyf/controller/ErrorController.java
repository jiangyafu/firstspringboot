package com.jyf.controller;

import com.jyf.domain.JSONResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/err")
public class ErrorController {
    @RequestMapping("/error")
    public String error(){
        int a = 1/0;
        return "thymeleaf/error";
    }


    @RequestMapping("/ajaxError")
    public String ajaxError(){
        return "thymeleaf/ajaxError";
    }

    @RequestMapping("/getAjaxerror")
    @ResponseBody
    public JSONResult getAjaxerror(){
        int a = 1/0;
        return JSONResult.ok();
    }
}
