package com.jyf.controller;

import com.jyf.domain.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @Auther: yafu jiang
 * @Date: 2019/11/14 0014 17:08
 * @Description:
 */
@Controller
@RequestMapping("ftl")
public class FreemarkerController {

    @Autowired
    private Resource resource;
    @RequestMapping("/index")
    public String index(ModelMap map ) {
        map.addAttribute("resource", resource);
        return "freemarker/index";
    }
    @RequestMapping("/main")
    public String center() {
        return "freemarker/main";
    }

}
