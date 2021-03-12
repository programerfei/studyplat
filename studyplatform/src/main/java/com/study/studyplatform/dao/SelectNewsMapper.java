package com.study.studyplatform.dao;

import com.study.studyplatform.pojo.News;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Mapper
@Repository
public interface SelectNewsMapper {
    //查询新闻
    List<News> selectAllNews(Map<String,Integer> map);

    long selectSumNews();

    List<String> selectAllNewsImages(Map<String,Integer> map);

    News selectNewsBuNewsid(Integer newsid);

    String selectNewsImagesById(Integer userid);

}
