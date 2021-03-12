package com.study.studyplatform.controller;

import com.study.studyplatform.pojo.*;
import com.study.studyplatform.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//跨域问题解决方法
@CrossOrigin(origins = {"http://cccccjy.top","null", "http://localhost:8080", "null"})
@RestController
@RequestMapping("/study")
public class StudyController {
    @Autowired
    private StudyService studyService;

    /**
     * 发布悬赏/学习内容（帖子）
     * @param studyPlat
     * @return
     */
    @GetMapping(value = "/updatestudy")
    public Result updateInfoProduction(StudyPlat studyPlat){
        return studyService.updateStudyInfomation(studyPlat);
    }

    /**
     * 发布学习评论（帖子）
     * @param reply
     * @return
     */
    @GetMapping(value = "/updatereply")
    public Result updateInfoProduction(Reply reply){
        return studyService.updateReplyStudyInfomation(reply);
    }

    /**
     * 查询学习数据
     * @param currentPage
     * @return
     */
    @GetMapping(value = "/findstudyinfo")
    public InitResult<List<ImagesUrl>> selectInfoProduction(Integer currentPage){
        return studyService.selectAllStudys(currentPage);
    }

    /**
     * 查询评论数据
     * @param currentPage
     * @return
     */
    @GetMapping(value = "/findreplyinfo")
    public InitResult<List<Reply>> selectInfoProduction(Integer studyplatid ,Integer currentPage){
        return studyService.selectAllStudyReplys(studyplatid,currentPage);
    }

    /**
     * 根据关键字查询学习结果
     * @param production
     * @param currentPage
     * @return
     */
    @GetMapping(value = "/findstudybystr")
    public InitResult<List<ImagesUrl>> selectInfoByStr(String production,Integer currentPage){
        return studyService.selectAllStudyByString(production,currentPage);
    }

    /**
     * 根据用户名查询学习结果
     * @param production
     * @param currentPage
     * @return
     */
    @GetMapping(value = "/findstudybyName")
    public InitResult<List<ImagesUrl>> selectInfoByUsername(String production,Integer currentPage){
        return studyService.selectAllStudyByStringName(production,currentPage);
    }

    /**
     * 点击查看详情页
     * @param studyplatid
     * @return
     */
    @GetMapping(value = "/findstudybyid")
    public ImagesUrl selectStudyById(Integer studyplatid,Integer hits){
        return studyService.findStudyByProid(studyplatid,hits);
    }

    /**
     * 个人主页学习区数据
     * @param userid
     * @param currentPage
     * @return
     */
    @GetMapping(value = "/findAllStudy")
    public InitResult<List<ImagesUrl>> selectInfoAllStudy(String userid,Integer currentPage){
        return studyService.selectAllStudyByUserid(userid,currentPage);
    }

    /**
     * 删除学习区信息
     * @param studyplatid
     */
    @GetMapping(value = "/deletestudy")
    public void deleteInfoByCommentid(int studyplatid){
        studyService.deleteAllStudy(studyplatid);
    }

    /**
     * 删除评论
     * @param replyid
     */
    @GetMapping(value = "/deletereply")
    public void deleteReplyByReplyid(int replyid){
        studyService.deleteAllReply(replyid);
    }
}
