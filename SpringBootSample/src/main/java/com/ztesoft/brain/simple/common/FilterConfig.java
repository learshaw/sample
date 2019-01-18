/*
 * 文 件 名:  WebConfiguration.java
 * 版    权:  
 * 描    述:  <描述>
 * 修 改 人:  LvWenbin
 * 修改时间:  2018/11/02 16:10
 */
package com.ztesoft.brain.simple.common;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ztesoft.brain.simple.controller.TestFilter;

/**
 * Filter拦截配置 <功能详细描述>
 * 
 * @author LvWenbin
 * @version [版本号, 2018/11/02 16:10]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Configuration
public class FilterConfig {
    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }
    
    @Bean
    public FilterRegistrationBean<TestFilter> testFilterRegistration() {
        FilterRegistrationBean<TestFilter> registration = new FilterRegistrationBean<TestFilter>();
        registration.setFilter(new TestFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("TestFilter");
        registration.setOrder(1);
        return registration;
    }
}