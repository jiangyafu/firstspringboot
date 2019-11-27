package com.jyf.config;

import com.jyf.controller.Inteceptor.OneInteceptor;
import com.jyf.controller.Inteceptor.TwoInteceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 拦截器按照顺序拦截
         */

        registry.addInterceptor(new OneInteceptor()).addPathPatterns("/one/**");
        registry.addInterceptor(new TwoInteceptor()).addPathPatterns("/two/**").addPathPatterns("/one/**");
        super.addInterceptors(registry);
    }


}
