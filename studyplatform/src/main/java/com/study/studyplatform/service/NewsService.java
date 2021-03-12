package com.study.studyplatform.service;

import com.study.studyplatform.pojo.InitResult;
import com.study.studyplatform.pojo.News;
import com.study.studyplatform.pojo.Result;

public interface NewsService {
    public InitResult findAllNews(Integer currentPage);

    public News findNewsByNewsid(Integer newsid);
}
