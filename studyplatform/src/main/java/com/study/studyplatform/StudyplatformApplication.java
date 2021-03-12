package com.study.studyplatform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.study.studyplatform.dao")
@SpringBootApplication
public class StudyplatformApplication {

    public static void main(String[] args) {
        System.setProperty("tomcat.util.http.parser.HttpParser.requestTargetAllow",":");
        SpringApplication.run(StudyplatformApplication.class, args);

    }

}
