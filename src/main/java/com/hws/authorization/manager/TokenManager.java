package com.hws.authorization.manager;

import com.hws.authorization.model.TokenModel;

/**
 * 对Token进行操作的接口
 * @author ScienJus
 * @date 2015/7/31.
 */
public interface TokenManager {

    /**
     * 创建一个token关联上指定用户
     * @param userId 指定用户的id
     * @return 生成的token
     */
    public void createToken(TokenModel model);

    /**
     * 检查token是否有效
     * @param model token
     * @return 是否有效
     */
    public TokenModel checkToken(String token);

    /**
     * 清除token
     * @param userId 登录用户的id
     */
    public void deleteToken(String token);

}
