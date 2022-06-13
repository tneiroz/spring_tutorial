package me.eun.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class RootConfig {
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource source
			= new ReloadableResourceBundleMessageSource();
		source.setBasenames("classpath:/message/message");
		source.setDefaultEncoding("utf-8");
		return source;
			
	}
	

}