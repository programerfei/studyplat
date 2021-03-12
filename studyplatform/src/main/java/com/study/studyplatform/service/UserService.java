package com.study.studyplatform.service;

import com.study.studyplatform.pojo.Result;
import com.study.studyplatform.pojo.User;

/**
 * 用户登录注册接口
 */
public interface UserService {
    /**
     * 注册方法,注册的时候默认状态为0：未激活，并且调用邮件服务发送激活码到邮箱
     * @param user
     * @return result
     */
    Result regist(User user);
    /**
     * 点击邮箱中的激活码进行激活，根据激活码查询用户，之后再进行修改用户状态为1进行激活
     * @param code
     * @return User
     */

    User checkCode(String code);
    /**
     * 激活账户，修改用户状态为“1”进行激活
     * @param user
     */

    void updateUserStatus(User user);
    /**
     * 登录，根据用户id或邮箱，密码以及状态为“1”来查询
     * @param user
     * @return user
     */

    Result login(User user);

    /**
     * 修改用户信息
     * @param user 用户
     */
    Result updateUserInfo(User user);
}
