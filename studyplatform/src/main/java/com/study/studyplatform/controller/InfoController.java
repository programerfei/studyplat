package com.study.studyplatform.controller;

import com.study.studyplatform.pojo.Comment;
import com.study.studyplatform.pojo.ImagesUrl;
import com.study.studyplatform.pojo.InitResult;
import com.study.studyplatform.pojo.Result;
import com.study.studyplatform.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//跨域问题解决方法
@CrossOrigin(origins = {"http://cccccjy.top","null", "http://localhost:8080", "null"})
@RestController
@RequestMapping("/info")
public class InfoController {
    @Autowired
    private InfoService infoService;

    /**
     * 发布悬赏/学习内容（帖子）
     * @param comment
     * @return
     */
    @GetMapping(value = "/updateinfo")
    public Result updateInfoProduction(Comment comment){
        return infoService.updateInfomation(comment);
    }

    /**
     * 查询悬赏数据
     * @param currentPage
     * @return
     */
    @GetMapping(value = "/findrewardinfo")
    public InitResult<List<ImagesUrl>> selectInfoProduction(Integer currentPage){
        return infoService.selectAllRewards(currentPage);
    }

    /**
     * 根据关键字查询悬赏结果
     * @param production
     * @param currentPage
     * @return
     */
    @GetMapping(value = "/findrewardbystr")
    public InitResult<List<ImagesUrl>> selectInfoByStr(String production,Integer currentPage){
        return infoService.selectAllByString(production,currentPage);
    }

    /**
     * 根据用户名查询悬赏结果
     * @param production
     * @param currentPage
     * @return
     */
    @GetMapping(value = "/findrewardbyName")
    public InitResult<List<ImagesUrl>> selectInfoByUsername(String production,Integer currentPage){
        return infoService.selectAllByStringName(production,currentPage);
    }

    /**
     * 点击查看详情页
     * @param commentid
     * @return
     */
    @GetMapping(value = "/findrewardbyid")
    public ImagesUrl selectRewardById(Integer commentid,Integer hits){
        return infoService.findRewardByProid(commentid,hits);
    }

    /**
     * 个人主页悬赏数据
     * @param userid
     * @param currentPage
     * @return
     */
    @GetMapping(value = "/findAllRewards")
    public InitResult<List<ImagesUrl>> selectInfoAllRewards(String userid,Integer currentPage){
        return infoService.selectAllRewardsByUserid(userid,currentPage);
    }

    /**
     * 删除悬赏信息
     * @param commentid
     */
    @GetMapping(value = "/deleteinfo")
    public void deleteInfoByCommentid(int commentid){
        infoService.deleteAllInfo(commentid);
    }


}
