package com.study.studyplatform.pojo;

import java.util.Date;

/**
 * 评论实体类
 */
public class Reply {
    private Integer replyid;
    private Integer studyplatid;
    private String userid;
    private String username;
    private String headportrait;
    private String replyinfo;
    private Date replytime;
    private String signature;
    private String introduction;

    private Integer startIndex;
    private Integer pageSize;

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getReplyid() {
        return replyid;
    }

    public void setReplyid(Integer replyid) {
        this.replyid = replyid;
    }

    public Integer getStudyplatid() {
        return studyplatid;
    }

    public void setStudyplatid(Integer studyplatid) {
        this.studyplatid = studyplatid;
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

    public String getHeadportrait() {
        return headportrait;
    }

    public void setHeadportrait(String headportrait) {
        this.headportrait = headportrait;
    }

    public String getReplyinfo() {
        return replyinfo;
    }

    public void setReplyinfo(String replyinfo) {
        this.replyinfo = replyinfo;
    }

    public Date getReplytime() {
        return replytime;
    }

    public void setReplytime(Date replytime) {
        this.replytime = replytime;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
