package com.jida.common.config;

import com.jida.common.filter.LimitReqFilter;
import com.jida.common.filter.SessionValidityFilter;
//import com.jida.common.filter.ShutdownContextListener;
import com.jida.common.filter.ShutdownContextListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    /*@Bean
    public ServletListenerRegistrationBean registrationListenerBean(){
        ServletListenerRegistrationBean bean = new ServletListenerRegistrationBean(new ShutdownContextListener());
        bean.setOrder(900);
        return bean;
    }*/

    @Bean
    public FilterRegistrationBean filterRegist() {
        FilterRegistrationBean frBean = new FilterRegistrationBean();
        frBean.setFilter(new SessionValidityFilter());
        frBean.setOrder(1);//多个过滤器时指定过滤器的执行顺序
        frBean.addUrlPatterns("/*");
        return frBean;
    }

    /*@Bean
    public FilterRegistrationBean filterRegist2() {
        FilterRegistrationBean frBean = new FilterRegistrationBean();
        frBean.setFilter(new ReLoginFilter());
        frBean.setOrder(2);//多个过滤器时指定过滤器的执行顺序
        frBean.addUrlPatterns("/*");
        return frBean;
    }*/

    @Bean
    public FilterRegistrationBean filterRegist3() {
        FilterRegistrationBean frBean = new FilterRegistrationBean();
        frBean.setFilter(new LimitReqFilter());
        frBean.setOrder(3);//多个过滤器时指定过滤器的执行顺序
        frBean.addUrlPatterns("/*");
        return frBean;
    }
}
