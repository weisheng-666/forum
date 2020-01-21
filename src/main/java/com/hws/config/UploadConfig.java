package com.hws.config;

import java.io.File;

import javax.servlet.MultipartConfigElement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UploadConfig {

    public static String path ;

    @Value("${spring.servlet.multipart.location}")
    public void setPath(String path) {
        UploadConfig.path = path;
        File fileDir = new File(path);
        if(!fileDir.exists())fileDir.mkdirs();
    }
}
