package com.study.studyplatform.pojo;

import java.util.Date;

public class Comment {
    private Integer commentid;//评论内容id
    private String userid;//用户id
    private String username;//用户名
    private String images;//头像
    private String rewardinfo;//悬赏内容
    private Date rewardtime;//发布时间
    private long rewardhits;//点击量

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

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

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getRewardinfo() {
        return rewardinfo;
    }

    public void setRewardinfo(String rewardinfo) {
        this.rewardinfo = rewardinfo;
    }

    public Date getRewardtime() {
        return rewardtime;
    }

    public void setRewardtime(Date rewardtime) {
        this.rewardtime = rewardtime;
    }

    public long getRewardhits() {
        return rewardhits;
    }

    public void setRewardhits(long rewardhits) {
        this.rewardhits = rewardhits;
    }
}
