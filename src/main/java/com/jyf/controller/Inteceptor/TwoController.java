package com.jyf.controller.Inteceptor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/two")
public class TwoController {
    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("name", "itzixi22");
        return "thymeleaf/index";
    }
}
