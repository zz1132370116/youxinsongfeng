package com.zl.dc.controller;

import com.zl.dc.entity.Purchase;
import com.zl.dc.service.PurchaseService;
import com.zl.dc.vo.BaseResult;
import org.apache.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
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

    @PostMapping("/releasePurchase")
    public ResponseEntity<BaseResult> releasePurchase(@RequestBody Purchase purchase, HttpServletRequest request){
        System.out.println(request.getParameter("productName"));
        System.out.println(purchase);
        //purchaseService.savePurchase(purchase);
        return ResponseEntity.ok(new BaseResult(0,"发布采购单成功"));
    }
}
