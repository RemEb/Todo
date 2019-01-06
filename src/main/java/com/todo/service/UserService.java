package com.todo.service;

import com.todo.model.LoginUser;
import com.todo.model.User;


/**
 * 用户服务接口，封装了用户的相关操作
 */
public interface UserService {

    /**
     * 登录
     * @param email 
     * @param pwd 
     * @return
     */
    public LoginUser login(String email, String pwd);

    /**
     * 注册用户
     * @param user 
     * @return
     */
    public LoginUser register(User user);

    /**
     * 更新个人信息
     * @param user 
     * @return
     */
    public LoginUser update(LoginUser user);

    /**
     * 更新密码
     * @param userId 
     * @param pwd 
     * @return
     */
    public boolean updatePwd(String userId, String pwd);

    /**
     * 执行忘记密码逻辑
     * @param userId 
     * @return
     */
    public boolean forgetPwd(String userId);

    /**
     * 获取用户信息，用户私密信息不暴露
     * @param userId 
     * @return
     */
    public LoginUser getUser(String userId);

}