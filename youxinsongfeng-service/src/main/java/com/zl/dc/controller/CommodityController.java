package com.zl.dc.controller;

import com.zl.dc.entity.Commodity;
import com.zl.dc.service.CommodityService;
import com.zl.dc.vo.BaseResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: 舌頭會游泳
 * @Date: 2019/7/11 16:16
 * @Description:
 */
@RestController
@RequestMapping
public class CommodityController {
    @Resource
    private CommodityService commodityService;

    /**
     * 条件查询分类
     */
    @PostMapping("/search")
    public ResponseEntity<BaseResult> search(@RequestBody Commodity commodity){
        //非空判断
        if (commodity !=null){
            //查询
            List<Commodity> list = commodityService.search(commodity);
            return ResponseEntity.ok(new BaseResult(0,"查询成功").append("data",list));
        }

        return ResponseEntity.ok(new BaseResult(1,"查询失败"));
    }

}
