package com.study.studyplatform.controller;

import com.study.studyplatform.dao.SelectUserMapper;
import com.study.studyplatform.pojo.Result;
import com.study.studyplatform.service.DownloadService;
import com.study.studyplatform.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;

//跨域问题解决方法
@CrossOrigin(origins = {"http://cccccjy.top", "null", "http://localhost:8080", "null"})
@RestController
public class HeadFileController {
    @Autowired
    private FileService fileService;

    @Autowired
    private DownloadService downloadService;


    /**
     * 上传头像文件接口
     * @param file 上传的文件
     * @return result,返回前端数据
     */
    @PostMapping(value = "/headimages")
    public Result uploadHeadFile(MultipartFile file){
        Result result=null;
        try {
            result=fileService.uploadHeadFile(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 上传图片文件接口
     * @param file 上传的文件
     * @return result,返回前端数据
     */
    @PostMapping(value = "/rewardimages")
    public Result uploadImagesFile(MultipartFile file){
        Result result=null;
        try {
            result=fileService.uploadImagesFile(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 上传文件接口
     * @param file 上传的文件
     * @return result,返回前端数据
     */
    @PostMapping(value = "/rewardfiles")
    public Result uploadFile(MultipartFile file){
        Result result=null;
        try {
            result=fileService.uploadFile(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 上传视频文件接口
     * @param file 上传的视频文件
     * @return result,返回前端数据
     */
    @PostMapping(value = "/rewardvideos")
    public Result uploadVideoFile(MultipartFile file){
        Result result=null;
        try {
            result=fileService.uploadVideoFile(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 下载接口
     *
     * @param name
     * @param response
     * @throws Exception
     */
    @GetMapping(value = "/download/{name}")
    public void logDownload(@PathVariable String name, HttpServletResponse response) throws Exception {
        downloadService.logDownload(name, response);
    }


}
