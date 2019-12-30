package com.imnu.shop.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//相当于web.xml
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	//加载Spring IOC 配置
	@Override
	protected Class<?>[] getRootConfigClasses() {
		//可以返回Spring的Java配置文件数组
		return new Class<?>[] {};
	}

	//加载bean
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {BeanConfig.class};
	}

	//DispatcherServlet拦截请求配置
	@Override
	protected String[] getServletMappings() {
		return new String[] {"*.action"};
	}

}
