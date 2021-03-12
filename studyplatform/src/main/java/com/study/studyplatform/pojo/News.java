package com.study.studyplatform.pojo;

import java.util.Date;

/**
 * 新闻实体类
 */
public class News {
    private int newsid;
    private String newsinfo;
    private Date newstime;
    private String[] newsimages;
    private String newstitle;
    private String author;

    public int getNewsid() {
        return newsid;
    }

    public void setNewsid(int newsid) {
        this.newsid = newsid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNewsinfo() {
        return newsinfo;
    }

    public void setNewsinfo(String newsinfo) {
        this.newsinfo = newsinfo;
    }

    public Date getNewstime() {
        return newstime;
    }

    public void setNewstime(Date newstime) {
        this.newstime = newstime;
    }

    public String[] getNewsimages() {
        return newsimages;
    }

    public void setNewsimages(String[] newsimages) {
        this.newsimages = newsimages;
    }

    public String getNewstitle() {
        return newstitle;
    }

    public void setNewstitle(String newstitle) {
        this.newstitle = newstitle;
    }
}
