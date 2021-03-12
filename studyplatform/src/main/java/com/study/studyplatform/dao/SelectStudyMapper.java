package com.study.studyplatform.dao;

import com.study.studyplatform.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 学习区dao层
 */
@Mapper
@Repository
public interface SelectStudyMapper {
    //查询学习区图片链接
    List<String> findStudyImages(Map<String,Integer> map);

    //查询除图片链接的数据
    List<ImagesUrl> findStudyPro(Map<String,Integer> map);

    //查找学习区发布内容的总数
    long findSumStudy();

    long findSumStudyByUserid(String userid);

    //根据关键字查询学习区总数
    long findSumStudyByString(String string);

    //根据关键字查询学习区评论总数
    long findSumReplyById(Integer studyplatid);

    //根据用户名学习区查询总数
    long findSumStudyByStringName(String username);

    //根据关键字模糊查询学习区内容
    List<ImagesUrl> findStudyByString(ParamObject param);

    //查询根据关键字查询的图片链接
    List<String> findStudyByStringImages(ParamObject paramObject);

    //查询根据关键字查询的图片链接
    List<String> findStudyByStringFiles(ParamObject paramObject);

    //查询根据关键字查询的图片链接
    List<String> findStudyByStringVideos(ParamObject paramObject);

    //根据用户名模糊查询
    List<ImagesUrl> findStudyByStringName(ParamObject param);

    //查询根据用户名查询的图片链接
    List<String> findStudyByStringNameImages(ParamObject paramObject);

    //查询根据用户名查询的图片链接
    List<String> findStudyByStringNameFiles(ParamObject paramObject);

    //查询根据用户名查询的图片链接
    List<String> findStudyByStringNameVideos(ParamObject paramObject);

    //根据悬赏id查询学习区内容详情
    ImagesUrl findStudyById(Integer studyplatid);

    //根据悬赏id查询学习区具体图片链接信息
    String findStudyImagesById(Integer studyplatid);

    //根据悬赏id查询学习区具体文件链接信息
    String findStudyFilesById(Integer studyplatid);

    //根据悬赏id查询学习区具体视频链接信息
    String findStudyVideosById(Integer studyplatid);

    //根据悬赏id查询学习区具体文件名字接信息
    String findStudyFilesNameById(Integer studyplatid);

    //根据悬赏id查询学习区具体视频名字接信息
    String findStudyVideosNameById(Integer studyplatid);

    //根据用户id查询用户的学习区数据
    List<ImagesUrl> findStudyProByUserid(Params paramObject);

    List<String> findStudyImagesByUserid(Params paramObject);

    //根据学习区资源id查询评论
    List<Reply> findReplyStudyByUserid(ReplyParam replyParam);
}
