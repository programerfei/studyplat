package com.study.studyplatform.service;

import com.study.studyplatform.pojo.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

public interface FileService {
    /**
     * 图片文件的上传
     * @param file 上传的头像文件
     */
    public Result uploadImagesFile(MultipartFile file) throws FileNotFoundException;

    /**
     * 头像文件的上传
     * @param file 上传的头像文件
     */
    public Result uploadHeadFile(MultipartFile file) throws FileNotFoundException;

    /**
     * 文件的上传
     * @param file 上传的文件
     */
    public Result uploadFile(MultipartFile file) throws FileNotFoundException;

    /**
     * 视频文件的上传
     * @param file 上传的视频文件
     */
    public Result uploadVideoFile(MultipartFile file) throws FileNotFoundException;
}
