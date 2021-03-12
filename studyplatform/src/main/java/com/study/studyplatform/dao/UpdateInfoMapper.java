package com.study.studyplatform.dao;

import com.study.studyplatform.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface UpdateInfoMapper {
    //发布内容
    int updateProduction(Comment comment);

    //点击量
    Long addProHits(Map<String,Integer> map);
}
