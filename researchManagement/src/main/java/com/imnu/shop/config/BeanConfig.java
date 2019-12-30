package com.imnu.shop.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.alibaba.druid.pool.DruidDataSource;

//读取配置文件
@Configuration
//扫描包
@ComponentScan("com.imnu.shop")
//开启mvc的注解
@EnableWebMvc
//开启事务
@EnableTransactionManagement
//读取properties配置文件
@PropertySource("classpath:application.properties")
//读取Mapper接口
@MapperScan("com.imnu.shop.mapper")
public class BeanConfig {
	@Value("${jdbc.driver}")
	private String classdriver;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;

	@Value("${mybatis.type.alias.package}")
	private String alisaPackage;
	@Value("${mybatis.mapper.mapperLocations}")
	private String mapperLocations;

	// 视图解析器
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	// 数据源
	@Bean
	public DataSource getDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(classdriver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	// 事务管理器
	@Bean
	public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	// 创建sqlSessionFactory
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws IOException {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		// 别名所在的包
		sqlSessionFactoryBean.setTypeAliasesPackage(alisaPackage);
		// 动态获取SqlMapper
		PathMatchingResourcePatternResolver classPathResource = new PathMatchingResourcePatternResolver();
		// mapper.xml映射文件
		sqlSessionFactoryBean.setMapperLocations(classPathResource.getResources(mapperLocations));
		return sqlSessionFactoryBean;
	}
}
