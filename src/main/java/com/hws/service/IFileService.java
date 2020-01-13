package com.hws.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
	 public void upload(String name,String md5, MultipartFile file) throws IOException ;
	 public void uploadWithBlock(String name,String md5,Long size,Integer chunks,Integer chunk, MultipartFile file) throws IOException; 
	 public boolean checkMd5(String md5);
}
