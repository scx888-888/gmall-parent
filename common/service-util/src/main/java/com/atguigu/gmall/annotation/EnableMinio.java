package com.atguigu.gmall.annotation;

import com.atguigu.gmall.minio.config.MinioAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author ： scx
 * @date ： 2022/7/26 10:37
 * @description：
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Import({MinioAutoConfiguration.class})
public @interface EnableMinio {

}
