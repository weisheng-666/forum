package com.hws.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hws.service.impl.FileService;

@RestController
@RequestMapping("upload")
@CrossOrigin
public class FileUploadController {
	
    @Autowired
    private FileService fileService;

    @PostMapping("file")
    public void upload(String name,String md5,MultipartFile file) throws IOException {
        fileService.upload(name, md5,file);        
    }
    
    @PostMapping("bigFile")
    public void upload(String name,String md5,Long size, Integer chunks,Integer chunk,MultipartFile file) throws IOException {
        if (chunks != null && chunks != 0) {
            fileService.uploadWithBlock(name, md5,size,chunks,chunk,file);
        } else {
            fileService.upload(name, md5,file);
        }
    }
   
}
