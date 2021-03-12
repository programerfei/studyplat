package com.study.studyplatform.dao;

import com.study.studyplatform.pojo.Reply;
import com.study.studyplatform.pojo.StudyPlat;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface UpdateStudyMapper {
    //发布内容
    int updateStudyProduction(StudyPlat studyPlat);

    //点击量
    Long addStudyHits(Map<String,Integer> map);

    //发布评论
    void updateReplyStudyInfo(Reply reply);
}
