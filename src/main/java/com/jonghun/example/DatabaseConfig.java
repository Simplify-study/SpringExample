package com.jonghun.example;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(basePackages="com.jonghun.example")
@EnableTransactionManagement
public class DatabaseConfig {

	Logger LOGGER = LoggerFactory.getLogger("LOGIN_LOG");
	
	@Autowired
	GlobalPropertySource globalPropertySource;
	
	@Bean
	@Primary
	public DataSource customDataSource() {
	    return DataSourceBuilder
	        .create()
	        .url(globalPropertySource.getUrl())
	        .driverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy")
	        .username(globalPropertySource.getUsername())
	        .password(globalPropertySource.getPassword())
	        .build();
	}
	
	@Bean
    public  SqlSessionFactory sqlSessionFactory(DataSource customDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(customDataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath:mybatis/mapper/*.xml"));
        return sessionFactory.getObject();
    }
    
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
      final SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
      return sqlSessionTemplate;
    }


}
