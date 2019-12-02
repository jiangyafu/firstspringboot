package com.jyf.zgirl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**  @Author jay 切面AOP
  * @Description //TODO
  * @Date 22:59 2019/12/2
  * @Param
  * @return
  **/
@Aspect
@Component
public class HttpAspect {


//    @Before("execution(public * com.jyf.zgirl.controller.GirlController.*(..))")
    /*@Before("execution(public * com.jyf.zgirl.controller.GirlController.saveGirl(..))")
    public void log(){
        System.out.println(" 11111111111111111111111111111111 " );

    }
    @After("execution(public * com.jyf.zgirl.controller.GirlController.saveGirl(..))")
    public void doAfter(){
        System.out.println(" 22222222222222222222222222222222222222222222 " );
    }
*/

    @Pointcut("execution(public * com.jyf.zgirl.controller.GirlController.saveGirl(..))")
    public void  aaa(){

    }

    @Before("aaa()")
    public void bbb(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        //logger.info(url={},request.getRequestURI());
        System.out.println("request = " + request.getRequestURI());
        //method
        System.out.println("request.getMethod() = " + request.getMethod());
        //ip
        System.out.println("request.getRemoteAddr() = " + request.getRemoteAddr());
        //类方法
        System.out.println( joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());

        //参数
        System.out.println("joinPoint = " + joinPoint.getArgs());
    }
    @After("aaa()")
    public void ccc(){

    }
    @AfterReturning(returning = "object",pointcut = "aaa()")
    public void doAfterReturning(Object object){
        System.out.println("object = " + object);

    }
}
