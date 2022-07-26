package com.atguigu.gmall.minio.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author ： scx
 * @date ： 2022/7/25 17:11
 * @description： minio的配置属性
 */
@Data
@ConfigurationProperties(prefix = "app.minio")
public class MinioProperties {

    String endpoint;


    String accessKey;


    String secretKey;


    String bucketName;
}
