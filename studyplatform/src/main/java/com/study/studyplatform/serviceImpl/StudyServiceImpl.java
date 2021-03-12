package com.study.studyplatform.serviceImpl;

import com.study.studyplatform.dao.DeleteUserInfoMapper;
import com.study.studyplatform.dao.SelectStudyMapper;
import com.study.studyplatform.dao.UpdateStudyMapper;
import com.study.studyplatform.pojo.*;
import com.study.studyplatform.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
@Service
public class StudyServiceImpl implements StudyService {

    @Autowired
    private SelectStudyMapper selectStudyMapper;

    @Autowired
    private UpdateStudyMapper updateStudyMapper;

    @Autowired
    private DeleteUserInfoMapper deleteUserInfoMapper;

    /**
     * 发布学习内容
     * @param studyPlat
     * @return
     */
    @Override
    public Result updateStudyInfomation(StudyPlat studyPlat) {
        Result result=new Result();
        result.setSuccess(false);

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        studyPlat.setStudytime(date);
        studyPlat.setStudyhits(0);

        updateStudyMapper.updateStudyProduction(studyPlat);
        result.setSuccess(true);
        result.setMsg("内容发布成功！");
//        result.setDetail(studyPlat);
        return result;
    }

    /**
     * 发布评论内容
     * @param reply
     * @return
     */
    @Override
    public Result updateReplyStudyInfomation(Reply reply) {
        Result result=new Result();
        result.setSuccess(false);

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        reply.setReplytime(date);

        updateStudyMapper.updateReplyStudyInfo(reply);
        result.setSuccess(true);
        result.setMsg("内容发布成功！");
//        result.setDetail(studyPlat);

        return result;
    }

    /**
     * 初始化学习内容
     * @param currentPage
     * @return
     */
    @Override
    public InitResult selectAllStudys(int currentPage) {
        InitResult result=new InitResult();
        result.setSuccess(false);
        result.setDetail(null);

        int pageSize = 20;  //每页显示几个
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("startIndex",(currentPage-1)*pageSize);
        map.put("pageSize",pageSize);

        List<ImagesUrl> res=new ArrayList<>();
        //新建查询，从数据库中得到除链接的其他信息
        res=selectStudyMapper.findStudyPro(map);
        //需要将图片的url进行分割
        List<String> list=selectStudyMapper.findStudyImages(map);
        for(int i=0;i<res.size();i++){
            String strImages= list.get(i);
            String[] images=null;
            if(strImages!=null){
                images=strImages.split(",");
            }
            ImagesUrl temp=res.get(i);
            temp.setImages(images);
        }


        long length= sumPage();//所有数据的数量
        long pageLength=0;
        if(length%20==0){
            pageLength=length/pageSize;
        }else{
            pageLength=length/pageSize+1;//符合要求的页数
        }
        result.setPageNumber(pageLength);

        if(res.isEmpty()){
            result.setMsg("平台暂时没有展示的数据");
            result.setPageNumber(0);
        }else{
            result.setMsg("展示最新的数据");
            result.setSuccess(true);
            result.setDetail(res);
        }
        return result;
    }

    /**
     * 初始化评论内容
     * @param currentPage
     * @return
     */
    @Override
    public InitResult selectAllStudyReplys(Integer studyplatid,int currentPage) {
        InitResult result=new InitResult();
        result.setSuccess(false);
        result.setDetail(null);

        int pageSize = 20;  //每页显示几个

        ReplyParam replyParam=new ReplyParam();
        replyParam.setPageSize(pageSize);
        replyParam.setStartIndex((currentPage-1)*pageSize);
        replyParam.setStudyplatid(studyplatid);

        List<Reply> res=new ArrayList<>();
        //新建查询，从数据库中得到除链接的其他信息
        res=selectStudyMapper.findReplyStudyByUserid(replyParam);

        long length= sumPage_reply(studyplatid);//所有数据的数量
        long pageLength=0;
        if(length%20==0){
            pageLength=length/pageSize;
        }else{
            pageLength=length/pageSize+1;//符合要求的页数
        }
        result.setPageNumber(pageLength);

        if(res.isEmpty()){
            result.setMsg("平台暂时没有展示的评论");
            result.setPageNumber(0);
        }else{
            result.setMsg("展示最新的评论数据");
            result.setSuccess(true);
            result.setDetail(res);
        }
        return result;
    }

    /**
     * 根据关键字查询
     * @param info
     * @param currentPage
     * @return
     */
    @Override
    public InitResult selectAllStudyByString(String info, Integer currentPage) {
        InitResult result=new InitResult();
        result.setSuccess(false);
        result.setDetail(null);

        List<ImagesUrl> list=new ArrayList<>();
        int pageSize = 20;  //每页显示几个数据

        ParamObject param=new ParamObject();
        param.setTargetObject(info);
        param.setStartIndex((currentPage-1)*pageSize);
        param.setPageSize(pageSize);
        list=selectStudyMapper.findStudyByString(param);

        //还需要根据关键字查询的图片链接
        List<String> lists=selectStudyMapper.findStudyByStringImages(param);

        //还需要根据关键字查询的文件链接
        List<String> lists_file=selectStudyMapper.findStudyByStringFiles(param);
        //还需要根据关键字查询的视频链接
        List<String> lists_video=selectStudyMapper.findStudyByStringVideos(param);

        if(!lists.isEmpty()){
            for(int i=0;i<list.size();i++){
                String strImages= lists.get(i);
                String[] images=null;
                if(strImages!=null){
                    images=strImages.split(",");
                }
                ImagesUrl temp=list.get(i);
                temp.setImages(images);
            }
        }


        if(!lists_file.isEmpty()){
            for(int i=0;i<list.size();i++){
                String strFiles= lists_file.get(i);
                String[] files=null;
                if(strFiles!=null){
                    files=strFiles.split(",");
                }
                ImagesUrl temp=list.get(i);
                temp.setFiles(files);
            }
        }


        if(!lists_video.isEmpty()){
            for(int i=0;i<list.size();i++){
                String strVideos= lists_video.get(i);
                String[] videos=null;
                if(strVideos!=null){
                    videos=strVideos.split(",");
                }
                ImagesUrl temp=list.get(i);
                temp.setVideos(videos);
            }
        }


        long length= sumPage_two(info);

        if(list.isEmpty()){
            result.setMsg("没有查到该关键字的相关数据");
            result.setSuccess(false);
            result.setPageNumber(0);
        }else{
            result.setMsg("该关键字的数据查找成功");
            result.setSuccess(true);
            long pageLength=0;
            if(length%20==0){
                pageLength=length/pageSize;
            }else{
                pageLength=length/pageSize+1;//符合要求的页数
            }
            result.setPageNumber(pageLength);
            result.setDetail(list);
        }
        return result;
    }

    /**
     * 根据用户名查询
     * @param info
     * @param currentPage
     * @return
     */
    @Override
    public InitResult selectAllStudyByStringName(String info, Integer currentPage) {
        InitResult result=new InitResult();
        result.setSuccess(false);
        result.setDetail(null);

        List<ImagesUrl> list=new ArrayList<>();
        int pageSize = 20;  //每页显示几个数据

        ParamObject param=new ParamObject();
        param.setTargetObject(info);
        param.setStartIndex((currentPage-1)*pageSize);
        param.setPageSize(pageSize);
        list=selectStudyMapper.findStudyByStringName(param);

        //还需要根据关键字查询的图片链接
        List<String> lists=selectStudyMapper.findStudyByStringNameImages(param);
        //还需要根据关键字查询的文件链接
        List<String> lists_file=selectStudyMapper.findStudyByStringNameFiles(param);
        //还需要根据关键字查询的视频链接
        List<String> lists_video=selectStudyMapper.findStudyByStringNameVideos(param);
        if(!lists.isEmpty()){
            for(int i=0;i<list.size();i++){
                String strImages= lists.get(i);
                String[] images=null;
                if(strImages!=null){
                    images=strImages.split(",");
                }
                ImagesUrl temp=list.get(i);
                temp.setImages(images);
            }
        }


        if(!lists_file.isEmpty()){
            for(int i=0;i<list.size();i++){
                String strFiles= lists_file.get(i);
                String[] files=null;
                if(strFiles!=null){
                    files=strFiles.split(",");
                }
                ImagesUrl temp=list.get(i);
                temp.setFiles(files);
            }
        }


        if(!lists_video.isEmpty()){
            for(int i=0;i<list.size();i++){
                String strVideos= lists_video.get(i);
                String[] videos=null;
                if(strVideos!=null){
                    videos=strVideos.split(",");
                }
                ImagesUrl temp=list.get(i);
                temp.setVideos(videos);
            }
        }




        long length= sumPage_three(info);

        if(list.isEmpty()){
            result.setMsg("没有查到该用户名关键字的相关数据");
            result.setSuccess(false);
            result.setPageNumber(0);
        }else{
            result.setMsg("该用户名关键字的数据查找成功");
            result.setSuccess(true);
            long pageLength=0;
            if(length%20==0){
                pageLength=length/pageSize;
            }else{
                pageLength=length/pageSize+1;//符合要求的页数
            }
            result.setPageNumber(pageLength);
            result.setDetail(list);
        }
        return result;
    }

    /**
     * 根据发布的学习内容id查询该内容详情
     * @param studyplatid
     * @param studyhits
     * @return
     */
    @Override
    public ImagesUrl findStudyByProid(Integer studyplatid, Integer studyhits) {
        String image=selectStudyMapper.findStudyImagesById(studyplatid);
        String[] images=image.split(",");

        String file=selectStudyMapper.findStudyFilesById(studyplatid);
        String[] files=file.split(",");

        String video=selectStudyMapper.findStudyVideosById(studyplatid);
        String[] videos=video.split(",");

        String filename=selectStudyMapper.findStudyFilesNameById(studyplatid);
        String[] filesnames=filename.split(",");

        String videoname=selectStudyMapper.findStudyVideosNameById(studyplatid);
        String[] videosnames=videoname.split(",");


        ImagesUrl imagesUrl= new ImagesUrl();
        //点击量 +1
        studyhits=studyhits+1;
        Map<String,Integer> map=new HashMap<>();
        map.put("studyplatid",studyplatid);
        map.put("studyhits",studyhits);
        updateStudyMapper.addStudyHits(map);
        imagesUrl= selectStudyMapper.findStudyById(studyplatid);

        imagesUrl.setImages(images);
        imagesUrl.setFiles(files);
        imagesUrl.setVideos(videos);

        imagesUrl.setFilename(filesnames);
        imagesUrl.setVideoname(videosnames);

        return imagesUrl;
    }

    @Override
    public InitResult selectAllStudyByUserid(String userid,int currentPage) {
        InitResult result=new InitResult();
        result.setSuccess(false);
        result.setDetail(null);

        int pageSize = 20;  //每页显示几个

        Params param=new Params();
        param.setUserid(userid);
        param.setStartIndex((currentPage-1)*pageSize);
        param.setPageSize(pageSize);

        List<ImagesUrl> res=new ArrayList<>();
        //新建查询，从数据库中得到除链接的其他信息
        res=selectStudyMapper.findStudyProByUserid(param);
        //需要将图片的url进行分割
        List<String> list=selectStudyMapper.findStudyImagesByUserid(param);
        if(!list.isEmpty()){
            for(int i=0;i<res.size();i++){
                String strImages= list.get(i);
                String[] images=null;
                if(strImages!=null){
                    images=strImages.split(",");
                }
                ImagesUrl temp=res.get(i);
                temp.setImages(images);
            }
        }


        long length= sumPage_ids(userid);//所有数据的数量
        long pageLength=0;
        if(length%20==0){
            pageLength=length/pageSize;
        }else{
            pageLength=length/pageSize+1;//符合要求的页数
        }
        result.setPageNumber(pageLength);

        if(res.isEmpty()){
            result.setMsg("您暂时没有在平台发布悬赏信息");
            result.setPageNumber(0);
        }else{
            result.setMsg("展示最新的数据");
            result.setSuccess(true);
            result.setDetail(res);
        }
        return result;
    }



    /**
     * 根据用户id和发布内容id删除信息
     * @param studyplatid
     */
    public void deleteAllStudy(int studyplatid){
        deleteUserInfoMapper.deleteStudyByUserid((studyplatid));
    }

    /**
     * 删除评论
     * @param replyid
     */
    public void deleteAllReply(int replyid){
        deleteUserInfoMapper.deleteReplyByReplyid(replyid);
    }

    /**
     * 初始化时返回页面的总数
     * @return int,页面数量
     */
    public long sumPage(){
        long length=0;
        length=selectStudyMapper.findSumStudy();
        return length;
    }

    /**
     * 根据关键搜索时返回页面的总数
     * @return int,页面数量
     */
    public long sumPage_two(String string){
        long length=0;
        length=selectStudyMapper.findSumStudyByString(string);
        return length;
    }

    /**
     * 根据用户名关键搜索时返回页面的总数
     * @return int,页面数量
     */
    public long sumPage_three(String string){
        long length=0;
        length=selectStudyMapper.findSumStudyByStringName(string);
        return length;
    }

    /**
     * 根据用户id搜索时返回页面的总数
     * @return int,页面数量
     */
    public long sumPage_ids(String string){
        long length=0;
        length=selectStudyMapper.findSumStudyByUserid(string);
        return length;
    }

    /**
     * 根据学习区id查找评论总数
     * @return int,页面数量
     */
    public long sumPage_reply(Integer studyplatid){
        long length=0;
        length=selectStudyMapper.findSumReplyById(studyplatid);
        return length;
    }
}
