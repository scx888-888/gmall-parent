package com.atguigu.gmall.minio.service.impl;

import com.atguigu.gmall.minio.config.MinioProperties;
import com.atguigu.gmall.minio.service.OssService;
import io.minio.MinioClient;
import io.minio.PutObjectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

/**
 * @author ： scx
 * @date ： 2022/7/25 17:22
 * @description：
 */
@Service
public class OssServiceImpl implements OssService {
    @Autowired
    MinioClient minioClient;

    @Autowired
    MinioProperties minioProperties;

    @Override
    public String uploadFile(MultipartFile file)throws Exception{
        String fileName = UUID.randomUUID().toString().replace("-","")+"_"+file.getOriginalFilename();

        InputStream inputStream = file.getInputStream();

        PutObjectOptions options = new PutObjectOptions(inputStream.available(),-1);

        String contentType = file.getContentType();
        options.setContentType(contentType);

        minioClient.putObject(minioProperties.getBucketName(), fileName,inputStream,options);

        String path = minioProperties.getEndpoint()+"/"+minioProperties.getBucketName()+"/"+fileName;
        return path;
    }
}
