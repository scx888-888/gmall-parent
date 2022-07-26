package com.atguigu.gmall.product.contorller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseCategory1;
import com.atguigu.gmall.model.product.BaseCategory2;
import com.atguigu.gmall.model.product.BaseCategory3;
import com.atguigu.gmall.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ： scx
 * @date ： 2022/7/19 20:48
 * @description： 商品分类
 */
@RestController
@RequestMapping("/admin/product")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    /**
     * 查询一级分类
     *
     * @return
     */
    @GetMapping("getCategory1")
    public Result getCategory1() {
        List<BaseCategory1> list = categoryService.getCategory1();
        return Result.ok(list);
    }

    /**
     * 查询二级分类
     * @param category1Id
     * @return
     */
    @GetMapping("getCategory2/{category1Id}")
    public Result getCategory2(@PathVariable("category1Id") Long category1Id) {
        List<BaseCategory2> list = categoryService.getCategory2(category1Id);
        return Result.ok(list);
    }

    /**
     * 查询三级分类
     * @param category2Id
     * @return
     */
    @GetMapping("getCategory3/{category2Id}")
    public Result getCategory3(@PathVariable("category2Id") Long category2Id) {
        List<BaseCategory3> list = categoryService.getCategory3(category2Id);
        return Result.ok(list);
    }
}
