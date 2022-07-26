package com.atguigu.gmall.minio.config;

import com.atguigu.gmall.minio.service.OssService;
import com.atguigu.gmall.minio.service.impl.OssServiceImpl;
import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ： scx
 * @date ： 2022/7/25 17:13
 * @description：
 */
@Configuration
@EnableConfigurationProperties(MinioProperties.class)
public class MinioAutoConfiguration {

    @Autowired
    MinioProperties minioProperties;
    @Bean
    public MinioClient minioClient() throws Exception {
        MinioClient minioClient = new MinioClient(minioProperties.getEndpoint(),
                minioProperties.getAccessKey(),minioProperties.getSecretKey());
        //boolean b = minioClient.bucketExists(minioProperties.getBucket());
        //if (!b){
        //    minioClient.makeBucket(minioProperties.getBucket());
        //}
        String bucketName = minioProperties.getBucketName();
        if (!minioClient.bucketExists(bucketName)) {

            minioClient.makeBucket(bucketName);
        }

        return minioClient;
    }

    @Bean
    public OssService ossService(){
        OssServiceImpl ossService = new OssServiceImpl();
        return ossService;
    }

}
