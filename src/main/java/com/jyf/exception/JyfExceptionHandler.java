package com.jyf.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: yafu jiang
 * @Date: 2019/11/14 0014 18:04
 * @Description:
 */
@ControllerAdvice
public class JyfExceptionHandler {
    public static final String ERROR_VIEW = "error";
	@ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest reqest,HttpServletResponse response, Exception e) throws Exception {
    	e.printStackTrace();
		ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", reqest.getRequestURL());
        mav.setViewName(ERROR_VIEW);
        return mav;
    }

}
