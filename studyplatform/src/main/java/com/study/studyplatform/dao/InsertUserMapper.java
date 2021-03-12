package com.study.studyplatform.dao;


import com.study.studyplatform.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
/**
 * 插入数据接口
 */
public interface InsertUserMapper {

    //插入用户id，用户名，密码，邮箱,即注册数据
    void insertRegist(User user);
}
