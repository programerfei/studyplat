package com.study.studyplatform.serviceImpl;

import com.study.studyplatform.pojo.Result;
import com.study.studyplatform.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public Result uploadImagesFile(MultipartFile file) throws FileNotFoundException {
        Result result=new Result();
        result.setSuccess(false);
        result.setDetail(null);

//        String path = ResourceUtils.getURL("classpath:").getPath()+"static/images/";

//
//        // 图片存储目录及图片名称
//        String url_path = "/images/" +  fileName;
//
//        //System.out.println("图片保存地址："+savePath);
//        // 访问路径=静态资源路径+文件目录路径
//        String visitPath = url_path;
//        //System.out.println("图片访问uri："+visitPath);
//
//        //图片保存路径
//        String savePath = path;
//        //若没有路径，则新创建
//        File saveFile = new File(savePath);
//        if (!saveFile.exists()){
//            saveFile.mkdirs();
//        }


        //因为我们无法操作jar包内容，所以我们只能将文件存放在别的位置，与jar包同级的目录是一个不错的选择。
        //1.首先获取根目录
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        if(!path.exists()) {
            path = new File("");
        }

        //获取文件名 加入时间戳防止重名
        String fileName = System.currentTimeMillis()+file.getOriginalFilename();

        //2.然后获取需要的目录，我们设定我们需要将文件存放在与jar包同级的static的upload目录下
        File upload = new File(path.getAbsolutePath(),"/static/images/");
        if(!upload.exists()) {
            upload.mkdirs();
        }

        //3.然后当我们要将上传的文件存储的时候，按照下面的方式去新建文件，然后使用你喜欢的方式进行存储。
        File uploadfile = new File(path.getAbsolutePath(),"/static/images/"+fileName);


        result.setMsg("文件上传成功");
        result.setSuccess(true);
        result.setDetail(fileName);
        try {
            file.transferTo(uploadfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        result.setMsg("文件上传成功");
//        result.setSuccess(true);
//        result.setDetail(userService.selectUrl());

//        File localFile=new File(savePath+fileName);
//        try {
//            file.transferTo(localFile);  //将临时存储的文件移动到真实存储路径下
//            result.setMsg("文件上传成功");
//            result.setSuccess(true);
//            result.setDetail(visitPath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return result;
    }

    /**
     * 上传头像文件
     * @param file 上传的头像文件
     */
    @Override
    public Result uploadHeadFile(MultipartFile file) throws FileNotFoundException {
        Result result=new Result();
        result.setSuccess(false);
        result.setDetail(null);

//        String path = ResourceUtils.getURL("classpath:").getPath()+"static/images/";

//
//        // 图片存储目录及图片名称
//        String url_path = "/images/" +  fileName;
//
//        //System.out.println("图片保存地址："+savePath);
//        // 访问路径=静态资源路径+文件目录路径
//        String visitPath = url_path;
//        //System.out.println("图片访问uri："+visitPath);
//
//        //图片保存路径
//        String savePath = path;
//        //若没有路径，则新创建
//        File saveFile = new File(savePath);
//        if (!saveFile.exists()){
//            saveFile.mkdirs();
//        }


        //因为我们无法操作jar包内容，所以我们只能将文件存放在别的位置，与jar包同级的目录是一个不错的选择。
        //1.首先获取根目录
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        if(!path.exists()) {
            path = new File("");
        }

        //获取文件名 加入时间戳防止重名
        String fileName = System.currentTimeMillis()+file.getOriginalFilename();

        //2.然后获取需要的目录，我们设定我们需要将文件存放在与jar包同级的static的upload目录下
        File upload = new File(path.getAbsolutePath(),"/static/heads/");
        if(!upload.exists()) {
            upload.mkdirs();
        }

        //3.然后当我们要将上传的文件存储的时候，按照下面的方式去新建文件，然后使用你喜欢的方式进行存储。
        File uploadfile = new File(path.getAbsolutePath(),"/static/heads/"+fileName);


        result.setMsg("文件上传成功");
        result.setSuccess(true);
        result.setDetail(fileName);
        try {
            file.transferTo(uploadfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        result.setMsg("文件上传成功");
//        result.setSuccess(true);
//        result.setDetail(userService.selectUrl());

//        File localFile=new File(savePath+fileName);
//        try {
//            file.transferTo(localFile);  //将临时存储的文件移动到真实存储路径下
//            result.setMsg("文件上传成功");
//            result.setSuccess(true);
//            result.setDetail(visitPath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return result;
    }

    /**
     * 上传文件
     * @param file 上传的头像文件
     */
    @Override
    public Result uploadFile(MultipartFile file) throws FileNotFoundException {
        Result result=new Result();
        result.setSuccess(false);
        result.setDetail(null);

//        String path = ResourceUtils.getURL("classpath:").getPath()+"static/images/";

//
//        // 图片存储目录及图片名称
//        String url_path = "/images/" +  fileName;
//
//        //System.out.println("图片保存地址："+savePath);
//        // 访问路径=静态资源路径+文件目录路径
//        String visitPath = url_path;
//        //System.out.println("图片访问uri："+visitPath);
//
//        //图片保存路径
//        String savePath = path;
//        //若没有路径，则新创建
//        File saveFile = new File(savePath);
//        if (!saveFile.exists()){
//            saveFile.mkdirs();
//        }


        //因为我们无法操作jar包内容，所以我们只能将文件存放在别的位置，与jar包同级的目录是一个不错的选择。
        //1.首先获取根目录
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        if(!path.exists()) {
            path = new File("");
        }

        //获取文件名 加入时间戳防止重名
        String fileName = System.currentTimeMillis()+file.getOriginalFilename();

        //2.然后获取需要的目录，我们设定我们需要将文件存放在与jar包同级的static的upload目录下
        File upload = new File(path.getAbsolutePath(),"/static/files/");
        if(!upload.exists()) {
            upload.mkdirs();
        }

        //3.然后当我们要将上传的文件存储的时候，按照下面的方式去新建文件，然后使用你喜欢的方式进行存储。
        File uploadfile = new File(path.getAbsolutePath(),"/static/files/"+fileName);


        result.setMsg("文件上传成功");
        result.setSuccess(true);
        result.setDetail(fileName);
        try {
            file.transferTo(uploadfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        result.setMsg("文件上传成功");
//        result.setSuccess(true);
//        result.setDetail(userService.selectUrl());

//        File localFile=new File(savePath+fileName);
//        try {
//            file.transferTo(localFile);  //将临时存储的文件移动到真实存储路径下
//            result.setMsg("文件上传成功");
//            result.setSuccess(true);
//            result.setDetail(visitPath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return result;
    }

    /**
     * 上传视频文件
     * @param file 上传的视频文件
     */
    @Override
    public Result uploadVideoFile(MultipartFile file) throws FileNotFoundException {
        Result result=new Result();
        result.setSuccess(false);
        result.setDetail(null);

//        String path = ResourceUtils.getURL("classpath:").getPath()+"static/images/";

//
//        // 图片存储目录及图片名称
//        String url_path = "/images/" +  fileName;
//
//        //System.out.println("图片保存地址："+savePath);
//        // 访问路径=静态资源路径+文件目录路径
//        String visitPath = url_path;
//        //System.out.println("图片访问uri："+visitPath);
//
//        //图片保存路径
//        String savePath = path;
//        //若没有路径，则新创建
//        File saveFile = new File(savePath);
//        if (!saveFile.exists()){
//            saveFile.mkdirs();
//        }


        //因为我们无法操作jar包内容，所以我们只能将文件存放在别的位置，与jar包同级的目录是一个不错的选择。
        //1.首先获取根目录
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        if(!path.exists()) {
            path = new File("");
        }

        //获取文件名 加入时间戳防止重名
        String fileName = System.currentTimeMillis()+file.getOriginalFilename();

        //2.然后获取需要的目录，我们设定我们需要将文件存放在与jar包同级的static的upload目录下
        File upload = new File(path.getAbsolutePath(),"/static/videos/");
        if(!upload.exists()) {
            upload.mkdirs();
        }

        //3.然后当我们要将上传的文件存储的时候，按照下面的方式去新建文件，然后使用你喜欢的方式进行存储。
        File uploadfile = new File(path.getAbsolutePath(),"/static/videos/"+fileName);


        result.setMsg("文件上传成功");
        result.setSuccess(true);
        result.setDetail(fileName);
        try {
            file.transferTo(uploadfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        result.setMsg("文件上传成功");
//        result.setSuccess(true);
//        result.setDetail(userService.selectUrl());

//        File localFile=new File(savePath+fileName);
//        try {
//            file.transferTo(localFile);  //将临时存储的文件移动到真实存储路径下
//            result.setMsg("文件上传成功");
//            result.setSuccess(true);
//            result.setDetail(visitPath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return result;
    }
}
