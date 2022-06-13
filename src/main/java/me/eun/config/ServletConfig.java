package me.eun.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import me.eun.interceptor.TestInterceptor;


@EnableWebMvc
@ComponentScan (basePackages = {"me.eun"})
public class ServletConfig implements WebMvcConfigurer{
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
	   InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	   viewResolver.setPrefix("/WEB-INF/views/");
	   viewResolver.setSuffix(".jsp");
 		registry.viewResolver(viewResolver);
	}
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		 registry.addResourceHandler("/resources/**")
		   .addResourceLocations("/resources/");
		
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new TestInterceptor())
		.addPathPatterns("/admin/**")
		.excludePathPatterns("/admin/aa","/admin/bb");
		LocaleChangeInterceptor localeChangeInterceptor
		 = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		registry.addInterceptor(localeChangeInterceptor);
		
	}
	@GetMapping("/admin/aa")
	public String aa() {
		System.out.println("컨트롤러 실행 aa()");
		return "aa";
		
	}
}