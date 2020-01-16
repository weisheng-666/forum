package com.hws.authorization.interceptor;

import java.lang.reflect.Method;
import java.util.Arrays;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hws.authorization.annotation.Authorization;
import com.hws.authorization.manager.TokenManager;
import com.hws.authorization.manager.impl.RedisTokenManager;
import com.hws.authorization.model.TokenModel;
import com.hws.config.Constants;
import com.hws.exception.UserNotLoginException;

/**
 * 自定义拦截器，判断此次请求是否有权限
 * @see com.scienjus.authorization.annotation.Authorization
 * @author ScienJus
 * @date 2015/7/30.
 */

@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private TokenManager tokenManager;

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        //如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        Class<?> clazz = handlerMethod.getBean().getClass();
        Authorization auth = clazz.getAnnotation(Authorization.class);
        auth = method.getAnnotation(Authorization.class);
        if(auth!=null) {
        	String authorization = request.getHeader(Constants.AUTHORIZATION);
        	System.out.println("-------------------------------");
        	System.out.println(authorization);
        	System.out.println("-------------------------------");
            TokenModel model = tokenManager.checkToken(authorization);
            boolean flag = true;
            if(model!=null) {
	            for(String str:auth.role()) {
	            	if(str.equals(model.getRole())) {
	            		flag=false;
	            	}	            		
	            }
            }
            //如果验证token失败，并且方法注明了Authorization，或者注明的角色与token中角色不符合，返回401错误
            if(flag) {
            	 System.out.println("用户未登录");
            	throw new UserNotLoginException();
            }
        	request.setAttribute(Constants.CURRENT_TOKEN_MODEL, model);
        }
        return true;
    }
}
