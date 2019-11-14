package com.jyf.controller;

import com.jyf.domain.Resource;
import com.jyf.utils.JSONResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: yafu jiang
 * @Date: 2019/11/14 0014 14:53
 * @Description:
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private Resource resource;

    @RequestMapping("/")
    public JSONResult hello(){
        Resource resource1 = new Resource();
        BeanUtils.copyProperties(resource1,resource);
        return JSONResult.ok(resource1);
    }
}
