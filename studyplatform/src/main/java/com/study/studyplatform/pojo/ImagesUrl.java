package com.study.studyplatform.pojo;

import java.util.Date;

public class ImagesUrl {
    private String userid;
    private String username;
    private String headportrait;
    private Integer commentid;
    private Integer studyplatid;
    private Date rewardtime;
    private Date studytime;
    private String rewardinfo;
    private String studyinfo;
    private String[] images;
    private Integer rewardhits;
    private Integer studyhits;
    private String[] files;
    private String[] filename;
    private String[] videos;
    private String[] videoname;
    private String introduction;
    private String signature;
    private int gender;


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

    public Integer getStudyplatid() {
        return studyplatid;
    }

    public void setStudyplatid(Integer studyplatid) {
        this.studyplatid = studyplatid;
    }

    public String getStudyinfo() {
        return studyinfo;
    }

    public void setStudyinfo(String studyinfo) {
        this.studyinfo = studyinfo;
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

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public Integer getRewardhits() {
        return rewardhits;
    }

    public void setRewardhits(Integer rewardhits) {
        this.rewardhits = rewardhits;
    }

    public String[] getVideos() {
        return videos;
    }

    public void setVideos(String[] videos) {
        this.videos = videos;
    }

    public String[] getFiles() {
        return files;
    }

    public void setFiles(String[] files) {
        this.files = files;
    }

    public String[] getFilename() {
        return filename;
    }

    public void setFilename(String[] filename) {
        this.filename = filename;
    }

    public String[] getVideoname() {
        return videoname;
    }

    public void setVideoname(String[] videoname) {
        this.videoname = videoname;
    }

    public Integer getStudyhits() {
        return studyhits;
    }

    public void setStudyhits(Integer studyhits) {
        this.studyhits = studyhits;
    }

    public Date getStudytime() {
        return studytime;
    }

    public void setStudytime(Date studytime) {
        this.studytime = studytime;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
