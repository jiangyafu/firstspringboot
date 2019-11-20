package com.jyf.exection;

import com.jyf.utils.JSONResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@RestControllerAdvice
public class JyfAjaxExceptionHandler {

//    @ExceptionHandler(Exception.class)
    public JSONResult defaultErrorHandler(HttpServletRequest request, HttpServletResponse response ,Exception e) throws Exception{
        e.printStackTrace();
        return JSONResult.errorException(e.getMessage());
    }
}
