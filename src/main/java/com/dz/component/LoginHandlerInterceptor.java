//package com.dz.component;
//
//import javax.servlet.http.*;
//import org.springframework.util.*;
//import org.springframework.web.servlet.*;
//
//public class LoginHandlerInterceptor implements HandlerInterceptor {
//
//  @Override
//  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//      throws Exception {
//    System.out.println(request.getSession().getAttribute("openId"));
//    if (!StringUtils.isEmpty(request.getSession().getAttribute("openId"))) {
//      return true;
//    }else{
//      return false;
//    }
//  }
//
//  @Override
//  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//      ModelAndView modelAndView) throws Exception {
//
//  }
//
//  @Override
//  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
//      Object handler, Exception ex) throws Exception {
//
//  }
//}
//
