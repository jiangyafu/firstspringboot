package com.jyf.controller;

import com.jyf.domain.Resource;
import com.jyf.domain.JSONResult;
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
@RequestMapping("")
public class HelloController {

    @Autowired
    private Resource resource;

    @RequestMapping("/hello")
    public Object hello(){
        return "hello springBoot~~~";
    }

    @RequestMapping("/getResource")
    public JSONResult getResource(){
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource,bean);
        return JSONResult.ok(bean);
    }
}
