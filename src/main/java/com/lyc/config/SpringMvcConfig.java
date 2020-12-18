package com.lyc.config;

import com.lyc.interceptor.*;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new JWTInterceptor())
        .addPathPatterns("/**")         // 拦截
        .excludePathPatterns("/login");// 放行
  }
}
