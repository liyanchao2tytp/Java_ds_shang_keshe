package com.dz.config;

import org.springframework.context.annotation.*;
import org.springframework.web.cors.*;

import org.springframework.web.filter.*;

//@Configuration
//public class CrossConfig {
//  @Bean
//  public WebMvcConfigurer corsConfigurer() {
//    return new WebMvcConfigurer() {
//      @Override
//      public void addCorsMappings(CorsRegistry registry) {
//        registry
//            .addMapping("/**") // 添加映射路径，“/**”表示对所有的路径实行全局跨域访问权限的设置
//            .allowedOrigins("http://127.0.0.1:8080") // 开放哪些ip、端口、域名的访问权限
//            .allowCredentials(true) // 是否允许发送Cookie信息
//            .allowedMethods("GET", "POST", "PUT", "DELETE") // 开放哪些Http方法，允许跨域访问
//            .allowedHeaders("*"); // 允许HTTP请求中的携带哪些Header信息
////            .exposedHeaders("*"); // 暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
//      }
//    };
//  }
//}

@Configuration
public class CrossConfig {
  @Bean
  public CorsFilter corsFilter(){
    //1.添加CORS配置信息
    CorsConfiguration config = new CorsConfiguration();
    //放行哪些原始域
//    config.addAllowedOrigin("*");
    config.addAllowedOriginPattern("http://*");
    //是否发送Cookie信息
    config.setAllowCredentials(true);
    //放行哪些原始域(请求方式)
    config.addAllowedMethod("*");
    //放行哪些原始域(头部信息)
    config.addAllowedHeader("*");
    //暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
//     config.addExposedHeader("*");
    config.addExposedHeader("Content-Type");
    config.addExposedHeader( "X-Requested-With");
    config.addExposedHeader("accept");
    config.addExposedHeader("Origin");
    config.addExposedHeader( "Access-Control-Request-Method");
    config.addExposedHeader("Access-Control-Request-Headers");

    //2.添加映射路径
    UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
    configSource.registerCorsConfiguration("/**", config);

    //3.返回新的CorsFilter.
    return new CorsFilter(configSource);
  }

}