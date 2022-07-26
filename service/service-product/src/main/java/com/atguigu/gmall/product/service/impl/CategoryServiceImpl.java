package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.BaseCategory1;
import com.atguigu.gmall.model.product.BaseCategory2;
import com.atguigu.gmall.model.product.BaseCategory3;
import com.atguigu.gmall.product.mapper.BaseCategory1Mapper;
import com.atguigu.gmall.product.mapper.BaseCategory2Mapper;
import com.atguigu.gmall.product.mapper.BaseCategory3Mapper;
import com.atguigu.gmall.product.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ： scx
 * @date ： 2022/7/20 15:11
 * @description：
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private BaseCategory1Mapper baseCategory1Dao;

    @Autowired
    private BaseCategory2Mapper baseCategory2Dao;

    @Autowired
    private BaseCategory3Mapper baseCategory3Dao;

    /**
     * 查询一级分类
     * @return
     */
    @Override
    public List<BaseCategory1> getCategory1() {
        List<BaseCategory1> category1List = baseCategory1Dao.selectList(null);
        return category1List;
    }

    @Override
    public List<BaseCategory2> getCategory2(Long category1Id) {
        QueryWrapper<BaseCategory2> wrapper = new QueryWrapper<>();
        wrapper.eq("category1_id",category1Id);
        List<BaseCategory2> category2List = baseCategory2Dao.selectList(wrapper);
        return category2List;
    }

    @Override
    public List<BaseCategory3> getCategory3(Long category2Id) {
        QueryWrapper<BaseCategory3> wrapper = new QueryWrapper<>();
        wrapper.eq("category2_id",category2Id);
        List<BaseCategory3> category3List = baseCategory3Dao.selectList(wrapper);
        return category3List;
    }
}
