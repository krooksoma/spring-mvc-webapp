package com.defaria.springmvcwebapp.interceptors;

import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class LoggingInterceptor extends WebRequestHandlerInterceptorAdapter {

    public LoggingInterceptor(WebRequestInterceptor requestInterceptor) {
        super(requestInterceptor);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      String sessionId = null;
//        get all cookies
      if(null !=request.getCookies()){
          for(Cookie cookie : request.getCookies()){
              if("JSESSIONID".equals(cookie.getName())){
                  sessionId = cookie.getName();
              }
          }
      }
        System.out.println("Incoming request data log: session: " + sessionId +
                " at " + new Date() + " for " + request.getRequestURI());

      return true;
//        log session id

//        log the request path

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("In postHandle interceptor");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
