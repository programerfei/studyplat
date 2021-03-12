package com.study.studyplatform.pojo;

import java.util.Date;

/**
 * 悬赏任务查询结果实体类
 */
public class Production {
    private String userid;
    private String username;
    private String headportrait;
    private Integer commentid;
    private Date rewardtime;
    private String rewardinfo;
    private String images;
    private Integer rewardhits;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHeadportrait() {
        return headportrait;
    }

    public void setHeadportrait(String headportrait) {
        this.headportrait = headportrait;
    }

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public Date getRewardtime() {
        return rewardtime;
    }

    public void setRewardtime(Date rewardtime) {
        this.rewardtime = rewardtime;
    }

    public String getRewardinfo() {
        return rewardinfo;
    }

    public void setRewardinfo(String rewardinfo) {
        this.rewardinfo = rewardinfo;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Integer getRewardhits() {
        return rewardhits;
    }

    public void setRewardhits(Integer rewardhits) {
        this.rewardhits = rewardhits;
    }
}
