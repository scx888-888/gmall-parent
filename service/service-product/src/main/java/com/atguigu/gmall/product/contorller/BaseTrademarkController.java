package com.atguigu.gmall.product.contorller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseTrademark;
import com.atguigu.gmall.product.service.BaseTrademarkService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ： scx
 * @date ： 2022/7/25 14:48
 * @description：
 */
@RestController
@RequestMapping("/admin/product")
public class BaseTrademarkController {

    @Autowired
    private BaseTrademarkService baseTrademarkService;

    @GetMapping("baseTrademark/{pageNum}/{pageSize}")
    public Result baseTrademark(@PathVariable("pageNum") Long pageNum,@PathVariable("pageSize") Long pageSize){
        Page<BaseTrademark> page = new Page<>(pageNum,pageSize);
        baseTrademarkService.page(page);

        Page<BaseTrademark> result = baseTrademarkService.page(page);

        return Result.ok(result);
    }

    /**
     * 添加品牌
     * @param baseTrademark
     * @return
     */
    @PostMapping("baseTrademark/save")
    public Result saveBaseTrademark(@RequestBody BaseTrademark baseTrademark){
        baseTrademarkService.save(baseTrademark);
        return  Result.ok();
    }

    @GetMapping("baseTrademark/get/{id}")
    public Result baseTrademark(@PathVariable Long id){
        BaseTrademark baseTrademark = baseTrademarkService.getById(id);
        return Result.ok(baseTrademark);
    }

    @PutMapping("baseTrademark/update")
    public Result updateBaseTrademark(@RequestBody BaseTrademark baseTrademark){
        baseTrademarkService.updateById(baseTrademark);
        return  Result.ok();
    }

    @DeleteMapping("baseTrademark/remove/{id}")
    public Result deleteBaseTrademark(@PathVariable Long id){

        baseTrademarkService.removeById(id);
        return Result.ok();
    }
}
