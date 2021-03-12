package com.study.studyplatform.dao;

import com.study.studyplatform.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
/**
 * 更新接口
 */
public interface UpdateUserMapper {
    void updateUserStatus(User user);

    //根据用户id跟新用户信息
    void updateUserByMail(User user);

    //编辑用户信息
    void updateUser(User user);
}
