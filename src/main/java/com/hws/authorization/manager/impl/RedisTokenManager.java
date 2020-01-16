package com.hws.authorization.manager.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Component;

import com.hws.authorization.manager.TokenManager;
import com.hws.authorization.model.TokenModel;
import com.hws.config.Constants;

/**
 * 通过Redis存储和验证token的实现类
 * @see com.scienjus.authorization.manager.TokenManager
 * @author ScienJus
 * @date 2015/7/31.
 */

@Component
public class RedisTokenManager implements TokenManager {

	
    private RedisTemplate<String, String> redisTemplate;

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Autowired
    public void setRedis(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        //泛型设置成Long后必须更改对应的序列化方案
        redisTemplate.setKeySerializer(new JdkSerializationRedisSerializer());
    }
    
    
    public void createToken(TokenModel model) {
        //存储到redis并设置过期时间
    	String token = redisTemplate.boundValueOps(model.getToken()).get();
    	if(token != null) {
    		redisTemplate.delete(token);
    	}
    	redisTemplate.boundValueOps(model.getToken()).set(model.getUserId()+"###"+model.getRole());
    	
    }

    public TokenModel checkToken(String token) {
    	
    	if(token == null || token.length() == 0) {
        	return null;
        }
    	String value = redisTemplate.boundValueOps(token).get();
    	
        if (value == null) {
            return null;
        }
    	String[] param = value.split("###");
    	if (param.length != 2) {
            return null;
        }

    	//如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
        redisTemplate.boundValueOps(token).expire(Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
        Long userId = Long.parseLong(param[0]);
        String role = param[1];
        return new TokenModel(userId, token,role); 
    }

    public void deleteToken( String token) {
    	redisTemplate.delete(token);
    }
}
