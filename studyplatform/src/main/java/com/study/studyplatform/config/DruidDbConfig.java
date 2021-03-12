package com.study.studyplatform.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

public class DruidDbConfig {
    private Logger logger = LoggerFactory.getLogger(DruidDbConfig.class);

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DruidDataSource druidConfig(){
        return new DruidDataSource();
    }
}
