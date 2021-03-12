package com.study.studyplatform.service;

import com.study.studyplatform.pojo.*;

public interface InfoService {
    //发布悬赏内容
    Result updateInfomation(Comment comment);

    /**
     * 初始化页面的展示数据
     * 初始化展示最新发布的二十条数据
     */
    public InitResult selectAllRewards(int currentPage);

    //根据关键字查询悬赏内容
    public InitResult selectAllByString(String info,Integer currentPage);

    //根据用户名查询
    public InitResult selectAllByStringName(String info, Integer currentPage);

    /**
     * 根据悬赏内容id得到悬赏内容详情
     */
    public ImagesUrl findRewardByProid(Integer commentid,Integer hits);

    //根据用户id查询用户的所有悬赏信息
    public InitResult selectAllRewardsByUserid(String userid,int currentPage);

    public void deleteAllInfo(int commentid);

}
