package me.eun.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan("me.eun.mapper")
public class RootConfig {
	
	@Bean
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		config.setJdbcUrl("jdbc:log4jdbc:mysql://localhost/member");
		config.setUsername("root");
		config.setPassword("1234");
		return new HikariDataSource(config);
		
	}
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource source
			= new ReloadableResourceBundleMessageSource();
		source.setBasenames("classpath:/message/message","classpath:/message/errors");
		source.setDefaultEncoding("utf-8");
		return source;
			
	}
	
	//locale은 다국어 처리를 위함
	@Bean
	public SessionLocaleResolver localeResolver() {
		return new SessionLocaleResolver();
	}
	@Bean
	public SqlSessionFactory sqlSessionFactory () throws Exception{
		SqlSessionFactoryBean sqlSessionFactoryBean 
		= new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		return sqlSessionFactoryBean.getObject();
	}
}