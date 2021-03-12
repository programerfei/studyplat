package com.study.studyplatform.serviceImpl;

import com.study.studyplatform.dao.DeleteUserInfoMapper;
import com.study.studyplatform.dao.SelectInfoMapper;
import com.study.studyplatform.dao.UpdateInfoMapper;
import com.study.studyplatform.pojo.*;
import com.study.studyplatform.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    private UpdateInfoMapper updateInfoMapper;

    @Autowired
    private SelectInfoMapper selectInfoMapper;

    @Autowired
    private DeleteUserInfoMapper deleteUserInfoMapper;

    @Override
    public Result updateInfomation(Comment comment) {
        Result result=new Result();
        result.setSuccess(false);

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        comment.setRewardtime(date);
        comment.setRewardhits(0);

        updateInfoMapper.updateProduction(comment);
        result.setSuccess(true);
        result.setMsg("内容发布成功！");

        return result;
    }

    /**
     * 初始化悬赏内容
     * @param currentPage
     * @return
     */
    @Override
    public InitResult selectAllRewards(int currentPage) {
        InitResult result=new InitResult();
        result.setSuccess(false);
        result.setDetail(null);

        int pageSize = 20;  //每页显示几个
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("startIndex",(currentPage-1)*pageSize);
        map.put("pageSize",pageSize);

        List<ImagesUrl> res=new ArrayList<>();
        //新建查询，从数据库中得到除链接的其他信息
        res=selectInfoMapper.findRewardPro(map);
        //需要将图片的url进行分割
        List<String> list=selectInfoMapper.findRewardImages(map);
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
     * 根据关键字查询悬赏内容
     * @param info
     * @param currentPage
     * @return
     */
    @Override
    public InitResult selectAllByString(String info, Integer currentPage) {
        InitResult result=new InitResult();
        result.setSuccess(false);
        result.setDetail(null);

        List<ImagesUrl> list=new ArrayList<>();
        int pageSize = 20;  //每页显示几个数据

        ParamObject param=new ParamObject();
        param.setTargetObject(info);
        param.setStartIndex((currentPage-1)*pageSize);
        param.setPageSize(pageSize);
        list=selectInfoMapper.findRewardByString(param);

        //还需要根据关键字查询的图片链接
        List<String> lists=selectInfoMapper.findRewardByStringImages(param);
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
     *根据用户名查询悬赏任务
     * @param info
     * @param currentPage
     * @return
     */
    @Override
    public InitResult selectAllByStringName(String info, Integer currentPage) {
        InitResult result=new InitResult();
        result.setSuccess(false);
        result.setDetail(null);

        List<ImagesUrl> list=new ArrayList<>();
        int pageSize = 20;  //每页显示几个数据

        ParamObject param=new ParamObject();
        param.setTargetObject(info);
        param.setStartIndex((currentPage-1)*pageSize);
        param.setPageSize(pageSize);
        list=selectInfoMapper.findRewardByStringName(param);

        //还需要根据关键字查询的图片链接
        List<String> lists=selectInfoMapper.findRewardByStringNameImages(param);
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
     * 根据悬赏内容id得到悬赏内容详情
     * 同时将点击量 +1
     */
    public ImagesUrl findRewardByProid(Integer commentid,Integer rewardhits){
        String image=selectInfoMapper.findRewardImagesById(commentid);
        String[] images=image.split(",");

        ImagesUrl imagesUrl= new ImagesUrl();
        //点击量 +1
        rewardhits=rewardhits+1;
        Map<String,Integer> map=new HashMap<>();
        map.put("commentid",commentid);
        map.put("rewardhits",rewardhits);
        updateInfoMapper.addProHits(map);
        imagesUrl= selectInfoMapper.findRewardById(commentid);

        imagesUrl.setImages(images);

        return imagesUrl;
    }

    @Override
    public InitResult selectAllRewardsByUserid(String userid,int currentPage) {
        InitResult result=new InitResult();
        result.setSuccess(false);
        result.setDetail(null);

        int pageSize = 20;  //每页显示几个
//        Map<String,Integer> map = new HashMap<String,Integer>();
//        map.put("startIndex",(currentPage-1)*pageSize);
//        map.put("pageSize",pageSize);

        Params param=new Params();
        param.setUserid(userid);
        param.setStartIndex((currentPage-1)*pageSize);
        param.setPageSize(pageSize);

        List<ImagesUrl> res=new ArrayList<>();
        //新建查询，从数据库中得到除链接的其他信息
        res=selectInfoMapper.findRewardProByUserid(param);
        //需要将图片的url进行分割
        List<String> list=selectInfoMapper.findRewardImagesByUserid(param);
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


        long length= sumPage_id(userid);//所有数据的数量
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
     * @param commentid
     */
    public void deleteAllInfo(int commentid){
        deleteUserInfoMapper.deleteInfoByUserid((commentid));
    }



    /**
     * 初始化时返回页面的总数
     * @return int,页面数量
     */
    public long sumPage(){
        long length=0;
        length=selectInfoMapper.findSumReward();
        return length;
    }

    /**
     * 根据关键搜索时返回页面的总数
     * @return int,页面数量
     */
    public long sumPage_two(String string){
        long length=0;
        length=selectInfoMapper.findSumRewardByString(string);
        return length;
    }

    /**
     * 根据用户名关键搜索时返回页面的总数
     * @return int,页面数量
     */
    public long sumPage_three(String string){
        long length=0;
        length=selectInfoMapper.findSumRewardByStringName(string);
        return length;
    }

    /**
     * 根据用户id搜索时返回页面的总数
     * @return int,页面数量
     */
    public long sumPage_id(String string){
        long length=0;
        length=selectInfoMapper.findSumRewardByUserid(string);
        return length;
    }
}
