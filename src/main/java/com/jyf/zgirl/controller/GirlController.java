package com.jyf.zgirl.controller;

import com.jyf.domain.JSONResult;
import com.jyf.zgirl.dao.GirlDao;
import com.jyf.zgirl.domain.Girl;
import com.jyf.zgirl.domain.Result;
import com.jyf.zgirl.service.GirlService;
import com.jyf.zgirl.utils.ResultUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.logging.Logger;

/**
 * 表单验证
 */
@RestController
@RequestMapping("/girl")
public class GirlController {


    @Autowired
    private GirlService girlService;

    @RequestMapping("/saveGirl")
    public Object saveGirl(@Valid Girl gril, BindingResult bindingResult){
        System.out.println("gril method ");
        if(bindingResult.hasErrors()){
            System.out.println("bindingResult = " + bindingResult.getFieldError().getDefaultMessage());
            return JSONResult.errorMsg(bindingResult.getFieldError().getDefaultMessage());
        }
        Integer result = girlService.insert(gril);
//        return JSONResult.ok(result);
        return gril;
    }

    @RequestMapping("/saveGirl1")
    public Object saveGirl1(@Valid Girl gril, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            /*Result result = new Result();
            result.setCode(1);
            result.setMeg(bindingResult.getFieldError().getDefaultMessage());*/
//            result.setData(null);
            System.out.println("bindingResult = " + bindingResult.getFieldError().getDefaultMessage());
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        Integer result = girlService.insert(gril);
//        return JSONResult.ok(result);

        /*Result result1 = new Result();
        result1.setCode(0);
        result1.setMeg("成功");
        result1.setData(result);*/
        return ResultUtil.success(result);
    }


    @RequestMapping("/getAge/{id}")
    public void getAge(@PathVariable Integer id) throws Exception {
        girlService.getAge(id);
    }
}
