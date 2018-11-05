/*
 * 文 件 名:  TestFilter.java
 * 版    权:  浩鲸云科技股份有限公司
 * 描    述:  <描述>
 * 修 改 人:  LvWenbin
 * 修改时间:  2018/11/02 16:38
 */
package com.ztesoft.brain.simple.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 测试拦截器 <功能详细描述>
 * 
 * @author LvWenbin
 * @version [版本号, 2018/11/02 16:38]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TestFilter implements Filter {
    /**
     * $服务启动-Filter加载
     * 
     * @param arg0
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig arg0)
        throws ServletException {
        System.out.println("## " + this.getClass() + " 加载...");
    }
    
    /**
     * $Filter拦截
     * 
     * @param arg0
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
        throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletRequest request = (HttpServletRequest)srequest;
        System.out.println("this is MyFilter,url :" + request.getRequestURI());
        filterChain.doFilter(srequest, sresponse);
    }
    
    /**
     * 服务停止-Filter消亡
     */
    @Override
    public void destroy() {
        System.out.println("## " + this.getClass() + " 消亡...");
    }
}