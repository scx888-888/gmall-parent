package com.atguigu.gmall.minio.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author ： scx
 * @date ： 2022/7/25 17:21
 * @description：
 */
public interface OssService {
    String uploadFile(MultipartFile file) throws IOException, Exception;
}
