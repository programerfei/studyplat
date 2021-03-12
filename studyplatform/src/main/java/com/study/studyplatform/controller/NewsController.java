package com.study.studyplatform.controller;

import com.study.studyplatform.pojo.ImagesUrl;
import com.study.studyplatform.pojo.InitResult;
import com.study.studyplatform.pojo.News;
import com.study.studyplatform.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//跨域问题解决方法
@CrossOrigin(origins = {"http://cccccjy.top","null", "http://localhost:8080", "null"})
@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping(value = "/findnewsinfo")
    public InitResult<List<ImagesUrl>> selectNewsInfoProduction(Integer currentPage){
        return newsService.findAllNews(currentPage);
    }

    @GetMapping(value = "/findnewsbyid")
    public News selectNewsInfoByNewsid(Integer newsid){
        return newsService.findNewsByNewsid(newsid);
    }
}
