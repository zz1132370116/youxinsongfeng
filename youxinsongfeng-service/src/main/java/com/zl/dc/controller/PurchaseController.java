package com.zl.dc.controller;

import com.zl.dc.entity.Purchase;
import com.zl.dc.service.PurchaseService;
import com.zl.dc.vo.BaseResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: 舌頭會游泳
 * @Date: 2019/7/16 10:32
 * @Description:
 */
@RestController
@RequestMapping
public class PurchaseController {
    @Resource
    private PurchaseService purchaseService;

    @GetMapping("/findAllPurchases")
    public ResponseEntity<BaseResult> findAllPurchases(){
        List<Purchase> list = purchaseService.findAllPurchases();
        return ResponseEntity.ok(new BaseResult(0,"查询成功").append("data",list));
    }
}
