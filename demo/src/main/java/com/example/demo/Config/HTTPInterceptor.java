package com.example.demo.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
@Configuration
public class HTTPInterceptor implements HandlerInterceptor {
    //Request before goes to controller
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("pre handle");
        //return HandlerInterceptor.super.preHandle(request, response, handler);
        return true;
    }
    //before sending the response to the client
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("post handle");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
    //after sending the response to the client.
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("after completion");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

}
