package com.study.studyplatform.utils;

import com.study.studyplatform.pojo.Result;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 图片上传类
 */
public class UpdateFile {
    //上传单张图片，主要用于上传头像
    public Result uploadFile(MultipartFile file) throws FileNotFoundException {
        Result result=new Result();
        result.setSuccess(false);
        result.setDetail(null);

        String path = ResourceUtils.getURL("classpath:").getPath()+"static";
        String fileName = file.getOriginalFilename();  //获取文件名
        fileName=System.currentTimeMillis()+fileName;  //加入时间戳防止重名

        // 图片存储目录及图片名称
        String url_path = "/images/" +  fileName;
        //图片保存路径
        String savePath = path +url_path;
        //System.out.println("图片保存地址："+savePath);
        // 访问路径=静态资源路径+文件目录路径
        String visitPath = url_path;
        //System.out.println("图片访问uri："+visitPath);

        File saveFile = new File(savePath);
        if (!saveFile.exists()){
            saveFile.mkdirs();
        }
        try {
            file.transferTo(saveFile);  //将临时存储的文件移动到真实存储路径下
            result.setMsg("文件上传成功");
            result.setSuccess(true);
            result.setDetail(visitPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
