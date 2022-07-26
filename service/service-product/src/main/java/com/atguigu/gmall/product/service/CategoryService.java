package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.BaseCategory1;
import com.atguigu.gmall.model.product.BaseCategory2;
import com.atguigu.gmall.model.product.BaseCategory3;

import java.util.List;

/**
 * @author ： scx
 * @date ： 2022/7/20 15:10
 * @description：
 */
public interface CategoryService {
    /**
     * 查询一级分类
     * @return
     */
    List<BaseCategory1> getCategory1();

    /**
     * 查询二级分类
     * @param category1Id
     * @return
     */
    List<BaseCategory2> getCategory2(Long category1Id);

    /**
     * 查询三级分类
     * @param category2Id
     * @return
     */
    List<BaseCategory3> getCategory3(Long category2Id);
}
