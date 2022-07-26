package com.atguigu.gmall.product.contorller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.minio.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ： scx
 * @date ： 2022/7/25 16:39
 * @description： 文件功能处理器
 */
@RestController
@RequestMapping("/admin/product")
public class FileController {

    @Autowired
    OssService ossService;


    @PostMapping("fileUpload")
    public Result fileUpload(MultipartFile file) throws Exception {
        String path = ossService.uploadFile(file);

        return Result.ok(path);
    }
}
