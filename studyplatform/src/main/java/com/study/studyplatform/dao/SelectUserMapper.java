package com.study.studyplatform.dao;

import com.study.studyplatform.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
/**
 * 查询数据接口
 */
public interface SelectUserMapper {
    //根据激活码code查询用户
    User checkCode(String code);

    //根据 status=1 进行查询
    User loginUser();

    //根据用户id或用户邮箱进行用户查询
    User selectUserByidmail(String str);

    //根据用户id查询密码
    String selectPwdByUserid(String id);

    //根据邮箱查询用户
    User selectUserByMail(String StringMail);

    //根据用户id查询用户
    User selectUserById(String UserId);

    //根据用户邮箱查询激活状态
    Integer selectStatusById(String usermail);

}
