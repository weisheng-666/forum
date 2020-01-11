package com.hws.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.hws.authorization.interceptor.AuthorizationInterceptor;

@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {
	
	@Autowired
	private AuthorizationInterceptor authorizationInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
        // 可添加多个
        registry.addInterceptor(authorizationInterceptor);
    }

}
