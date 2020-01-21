package com.hws.service.impl;

import com.hws.config.UploadConfig;
import com.hws.dao.FileMapper;
import com.hws.exception.BusinessException;
import com.hws.model.File;
import com.hws.service.IFileService;
import com.hws.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

import static com.hws.utils.FileUtils.generateFileName;
import static com.hws.utils.UploadUtils.*;

/**
 * 文件上传服务
 */
@Service("fileService")
public class FileServiceImpl implements IFileService {
	
    @Autowired
    private FileMapper fileDao;

    /**
     * 上传文件
     * @param md5
     * @param file
     */
    public void upload(String name,
                       String md5,
                       MultipartFile file) {
    	//try {
	        String path = UploadConfig.path +generateFileName()+file.getOriginalFilename();
	        System.out.println("存储路径:"+path);
	        try {
				FileUtils.write(path, file.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        File file1 = new File(name, md5, path, new Date());
	        System.out.println(file1);
	        fileDao.save(file1);
    	//}catch (Exception e) {
		//	throw new BusinessException();
		//}
    }

    /**
     * 分块上传文件
     * @param md5
     * @param size
     * @param chunks
     * @param chunk
     * @param file
     * @throws IOException
     */
    public void uploadWithBlock(String name,
                                String md5,
                                Long size,
                                Integer chunks,
                                Integer chunk,
                                MultipartFile file) throws IOException {
        String fileName = getFileName(md5, chunks);
        System.out.println("存储路径:"+fileName);
        FileUtils.writeWithBlok(UploadConfig.path + fileName, size, file.getInputStream(), file.getSize(), chunks, chunk);
        addChunk(md5,chunk);
        if (isUploaded(md5)) {
            removeKey(md5);
            fileDao.save(new File(name, md5,UploadConfig.path + fileName, new Date()));
        }
    }

    /**
     * 检查Md5判断文件是否已上传
     * @param md5
     * @return
     */
    public boolean checkMd5(String md5) {
        File file = new File();
        file.setMd5(md5);
        return fileDao.getByFile(file) == null;
    }

	@Override
	public void upload(long id, MultipartFile file) {
		try {
			String type = file.getOriginalFilename();
			
	        String path = UploadConfig.path +"head/"+id+ type.substring(type.lastIndexOf("."));
	       
	        System.out.println(path);
	        FileUtils.write(path, file.getInputStream());
    	}catch (Exception e) {
			throw new BusinessException();
		}
		
	}
}
