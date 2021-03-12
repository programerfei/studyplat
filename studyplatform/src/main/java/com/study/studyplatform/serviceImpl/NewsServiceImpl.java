package com.study.studyplatform.serviceImpl;

import com.study.studyplatform.dao.SelectNewsMapper;
import com.study.studyplatform.pojo.InitResult;
import com.study.studyplatform.pojo.News;
import com.study.studyplatform.pojo.Result;
import com.study.studyplatform.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private SelectNewsMapper selectNewsMapper;

    @Override
    public InitResult findAllNews(Integer currentPage) {
        InitResult result=new InitResult();
        result.setSuccess(false);
        result.setDetail(null);

        int pageSize = 20;  //每页显示几个
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("startIndex",(currentPage-1)*pageSize);
        map.put("pageSize",pageSize);

        List<News> res=new ArrayList<>();
        //新建查询，从数据库中得到除链接的其他信息
        res=selectNewsMapper.selectAllNews(map);
        //需要将图片的url进行分割
        List<String> list=selectNewsMapper.selectAllNewsImages(map);
        if(!list.isEmpty()){
            for(int i=0;i<list.size();i++){
                String strImages= list.get(i);
                String[] images=null;
                if(strImages!=null){
                    images=strImages.split(",");
                }
                News temp=res.get(i);
                temp.setNewsimages(images);
            }
        }
        for(int i=0;i<list.size();i++){
            String strImages= list.get(i);
            String[] images=null;
            if(strImages!=null){
                images=strImages.split(",");
            }
            News temp=res.get(i);
            temp.setNewsimages(images);
        }

        long length= sumPage_news();//所有数据的数量
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

    public News findNewsByNewsid(Integer newsid){
        String image=selectNewsMapper.selectNewsImagesById(newsid);

        News tempNews= selectNewsMapper.selectNewsBuNewsid(newsid);
        String[] images=null;
        if(image!=null){
            images=image.split(",");
        }
        tempNews.setNewsimages(images);
        return tempNews;
    }



    public long sumPage_news(){
        long length=0;
        length=selectNewsMapper.selectSumNews();
        return length;
    }
}
