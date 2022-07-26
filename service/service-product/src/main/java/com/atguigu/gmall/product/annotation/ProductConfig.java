package com.atguigu.gmall.product.annotation;

import com.atguigu.gmall.common.config.MybatisPlusConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ： scx
 * @date ： 2022/7/25 16:18
 * @description：
 */
@EnableTransactionManagement
@MapperScan(basePackages = "com.atguigu.gmall.product.mapper")
@Import(MybatisPlusConfig.class)
@Target({ElementType.TYPE,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ProductConfig {
}
