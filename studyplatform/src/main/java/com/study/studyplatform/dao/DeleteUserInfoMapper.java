package com.study.studyplatform.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
/**
 * 数据库的删除操作
 */
public interface DeleteUserInfoMapper {
    public void deleteInfoByUserid(Integer commentid);

    public void deleteStudyByUserid(Integer studyplatid);

    public void deleteReplyByReplyid(Integer replyid);
}
