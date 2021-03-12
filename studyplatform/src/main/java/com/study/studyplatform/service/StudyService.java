package com.study.studyplatform.service;

import com.study.studyplatform.pojo.*;

public interface StudyService {
    //发布学习区内容
    Result updateStudyInfomation(StudyPlat studyPlat);

    /**
     * 初始化页面的展示数据
     * 初始化展示最新发布的二十条数据
     */
    public InitResult selectAllStudys(int currentPage);

    //根据关键字查询悬赏内容
    public InitResult selectAllStudyByString(String info,Integer currentPage);

    //根据用户名查询
    public InitResult selectAllStudyByStringName(String info, Integer currentPage);

    /**
     * 根据悬赏内容id得到悬赏内容详情
     */
    public ImagesUrl findStudyByProid(Integer studyplatid, Integer hits);

    //根据用户id查询用户的所有学习区信息
    public InitResult selectAllStudyByUserid(String userid,int currentPage);

    public void deleteAllStudy(int studyplatid);

    public Result updateReplyStudyInfomation(Reply reply);

    public InitResult selectAllStudyReplys(Integer studyplatid,int currentPage);

    public void deleteAllReply(int replyid);
}
