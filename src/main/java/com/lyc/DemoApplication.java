package com.lyc;

import org.mybatis.spring.annotation.*;
import org.springframework.beans.*;
import org.springframework.beans.factory.config.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.*;
import org.springframework.context.annotation.*;

@SpringBootApplication
@MapperScan("com.lyc.mapper")
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }
  @Bean
  public static BeanFactoryPostProcessor beanFactoryPostProcessor() {
    return new BeanFactoryPostProcessor() {

      @Override
      public void postProcessBeanFactory(
          ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition bean = beanFactory.getBeanDefinition(
            DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);

        bean.getPropertyValues().add("loadOnStartup", 1);
      }
    };
  }
}
