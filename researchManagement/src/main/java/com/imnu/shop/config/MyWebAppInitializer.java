package com.imnu.shop.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//�൱��web.xml
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	//����Spring IOC ����
	@Override
	protected Class<?>[] getRootConfigClasses() {
		//���Է���Spring��Java�����ļ�����
		return new Class<?>[] {};
	}

	//����bean
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {BeanConfig.class};
	}

	//DispatcherServlet������������
	@Override
	protected String[] getServletMappings() {
		return new String[] {"*.action"};
	}

}
