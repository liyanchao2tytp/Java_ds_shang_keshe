package com.lyc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.*;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2 // 开启Swagger2
public class SwaggerConfig {

  // 配置swagger的docket的bean实例
  @Bean
  public Docket docket() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName("lyc")
        .apiInfo(apiInfo())
        // 是否启用swagger  false ：swagger不能在游览器中访问
        // .enable(false)
        .select()
        // RequestHandlerSelectors 配置了扫描接口的方式
        // basePackage  指定要扫描的包
        // any() 扫描全部
        // none() 不扫描
        // withClassAnnotation 扫描类上的
        // withMethodAnnotation
        .apis(RequestHandlerSelectors.basePackage("com.lyc.controller"))
        // 过滤什么路径
        //        .paths(PathSelectors.ant("/lyc/**"))
        .build();
  }

  private ApiInfo apiInfo() {
    Contact contact = new Contact("李燕超", "", "934781829@qq.com");
    return new ApiInfo(
        "我的SwaggerApi文档",
        "大三上学期Java课设",
        "1.0",
        "https://liyanchao2tytp.github.io/",
        contact,
        "Apache 2.0",
        "http://www.apache.org/licenses/LICENSE-2.0",
        new ArrayList());
  }
}
