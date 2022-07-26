package com.atguigu.gmall.product.contorller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ： scx
 * @date ： 2022/7/19 20:24
 * @description：
 */
@RestController
public class Hello {



    @GetMapping("/hello")
    public String test(){
        return "hello 沈楚雄";
    }

    //@PostMapping("/upload")
    //public void test(MultipartFile file){
    //    test.upload(file);
    //}
}
