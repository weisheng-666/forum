package com.hws.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.hws.authorization.interceptor.AuthorizationInterceptor;
import com.hws.authorization.resolvers.CurrentUserMethodArgumentResolver;

@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {
	
	@Autowired
	private AuthorizationInterceptor authorizationInterceptor;
	
	@Autowired
	private CurrentUserMethodArgumentResolver currentUserMethodArgumentResolver;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
        // 可添加多个
        registry.addInterceptor(authorizationInterceptor);
    }
	
	@Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
        argumentResolvers.add(currentUserMethodArgumentResolver);
    }

}
