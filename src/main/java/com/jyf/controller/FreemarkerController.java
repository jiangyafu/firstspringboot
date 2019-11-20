package com.jyf.controller;

import com.jyf.domain.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ftl")
public class FreemarkerController {

    @Autowired
    private Resource resource;

    @RequestMapping("/index")
    public String index(Model model, ModelMap modelMap){
        model.addAttribute("resource",resource);
        return "freemarker/index";
    }

    @RequestMapping("/center")
    public String center(){
        return "freemarker/center/center";
    }
}
