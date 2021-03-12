package com.study.studyplatform.pojo;

import java.util.Date;

/**
 * 学习区实体类
 */
public class StudyPlat {
    private int studyplatid;
    private String userid;
    private String studyinfo;
    private Date studytime;
    private int studyhits;
    private String images;
    private String files;
    private String videos;
    private String filename;
    private String videoname;
    private String videopath;

    public int getStudyplatid() {
        return studyplatid;
    }

    public void setStudyplatid(int studyplatid) {
        this.studyplatid = studyplatid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getStudyinfo() {
        return studyinfo;
    }

    public void setStudyinfo(String studyinfo) {
        this.studyinfo = studyinfo;
    }

    public Date getStudytime() {
        return studytime;
    }

    public void setStudytime(Date studytime) {
        this.studytime = studytime;
    }

    public int getStudyhits() {
        return studyhits;
    }

    public void setStudyhits(int studyhits) {
        this.studyhits = studyhits;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getVideos() {
        return videos;
    }

    public void setVideos(String videos) {
        this.videos = videos;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getVideoname() {
        return videoname;
    }

    public void setVideoname(String videoname) {
        this.videoname = videoname;
    }

    public String getVideopath() {
        return videopath;
    }

    public void setVideopath(String videopath) {
        this.videopath = videopath;
    }
}
