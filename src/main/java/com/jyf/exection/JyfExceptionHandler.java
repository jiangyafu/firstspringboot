package com.jyf.exection;

import com.jyf.utils.JSONResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class JyfExceptionHandler {

    public static final String JYF_ERROR_VIEW = "thymeleaf/error";
//    @ExceptionHandler(value = Exception.class)
//    public Object errorHandler(HttpServletRequest request, HttpServletResponse response,Exception e) throws Exception{
//        e.printStackTrace();
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("exception",e);
//        modelAndView.addObject("url",request.getRequestURL());
//        modelAndView.setViewName(JYF_ERROR_VIEW);
//        return modelAndView;
//    }


    @ExceptionHandler(value = Exception.class)
    public Object errorHandler (HttpServletRequest request, HttpServletResponse response,Exception e)throws Exception{
        e.printStackTrace();
        if(isAjax(request)){
            return JSONResult.errorException(e.getMessage());
        }else{
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("exception",e);
            modelAndView.addObject("url",request.getRequestURL());
            modelAndView.setViewName(JYF_ERROR_VIEW);
            return modelAndView;
        }
    }


    /**
     *
     * @Title: IMoocExceptionHandler.java
     * @Package com.imooc.exception
     * @Description: 判断是否是ajax请求
     * Copyright: Copyright (c) 2017
     * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
     *
     * @author leechenxiang
     * @date 2017年12月3日 下午1:40:39
     * @version V1.0
     */
    public static boolean isAjax(HttpServletRequest httpRequest){
        return  (httpRequest.getHeader("X-Requested-With") != null && "XMLHttpRequest".equals( httpRequest.getHeader("X-Requested-With").toString()) );
    }
}
