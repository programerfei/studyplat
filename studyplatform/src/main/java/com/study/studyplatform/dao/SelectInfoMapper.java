package com.study.studyplatform.dao;

import com.study.studyplatform.pojo.ImagesUrl;
import com.study.studyplatform.pojo.ParamObject;
import com.study.studyplatform.pojo.Params;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
/**
 * 查询发布悬赏接口，分页查询，每页20条数据
 */
public interface SelectInfoMapper {

    //查询图片链接
    List<String> findRewardImages(Map<String,Integer> map);

    //查询除图片链接的数据
    List<ImagesUrl> findRewardPro(Map<String,Integer> map);

    //查找悬赏的总数
    long findSumReward();

    //根据关键字查询总数
    long findSumRewardByString(String string);

    //根据用户名查询总数
    long findSumRewardByStringName(String username);

    //根据用户id查询所有悬赏的数据量
    long findSumRewardByUserid(String userid);

    //根据关键字模糊查询
    List<ImagesUrl> findRewardByString(ParamObject param);

    //查询根据关键字查询的图片链接
    List<String> findRewardByStringImages(ParamObject paramObject);

    //根据用户名模糊查询
    List<ImagesUrl> findRewardByStringName(ParamObject param);

    //查询根据用户名查询的图片链接
    List<String> findRewardByStringNameImages(ParamObject paramObject);

    //根据悬赏id查询悬赏内容详情
    ImagesUrl findRewardById(Integer commentid);

    //根据悬赏id查询悬赏具体图片链接信息
    String findRewardImagesById(Integer commentid);

    //根据用户查询用户的悬赏信息
    List<ImagesUrl> findRewardProByUserid(Params params);

    List<String> findRewardImagesByUserid(Params params);
}
