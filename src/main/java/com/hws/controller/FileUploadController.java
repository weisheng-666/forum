package com.hws.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hws.authorization.annotation.CurrentUser;
import com.hws.domain.User;
import com.hws.domain.dto.UserDto;
import com.hws.service.IFileService;
import com.hws.service.impl.FileServiceImpl;

@RestController
//@RequestMapping("upload")
@CrossOrigin
public class FileUploadController {
	
    @Autowired
    private IFileService fileService;
    
    @PostMapping("image")//头像接口
    public void head(@CurrentUser UserDto user,MultipartFile file) {
    	System.out.println(user.getId());
        fileService.upload(user.getId(),file);        
    }

    @PostMapping("file")//小文件接口
    public void upload(/*@CurrentUser UserDto user*/String name,String md5,MultipartFile myFile,HttpServletRequest res) {
    	//System.out.println(user.getId());
    	name="1";md5="1";
        fileService.upload(name, md5,myFile);        
    }
    
    @PostMapping("BigFile")//大文件接口
    public void upload(String name,String md5,Long size, Integer chunks,Integer chunk,MultipartFile file) throws IOException {
    	System.out.println("name:"+name+" md5:"+md5+" size:"+size+" chunks:"+chunks+" chunk:"+chunk);
        if (chunks != null && chunks != 0) {
            fileService.uploadWithBlock(name, md5,size,chunks,chunk,file);
        } else {
            fileService.upload(name, md5,file);
        }
    }
   
}
