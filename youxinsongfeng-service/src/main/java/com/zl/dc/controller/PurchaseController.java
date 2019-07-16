package com.zl.dc.controller;

import com.github.pagehelper.PageInfo;
import com.zl.dc.entity.Purchase;
import com.zl.dc.service.PurchaseService;
import com.zl.dc.vo.PageBean;
import com.zl.dc.vo.BaseResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 查询所有采购信息
     * @return
     */
    @GetMapping ("/findAllPurchases/{cur}")
    public ResponseEntity<BaseResult> findAllPurchases(@PathVariable("cur") Integer cur){
        PageInfo<Purchase> allPurchases = purchaseService.findAllPurchases(cur);
        return ResponseEntity.ok(new BaseResult(0,"查询成功").append("pagesize",allPurchases.getPages()).append("data", allPurchases.getList()));
    }

    /**
     * 通过id查询采购详情
     * @param p
     * @return
     */
    @PostMapping("/findPurchasesByid")
    public ResponseEntity<BaseResult> findPurchasesByid(@RequestBody Purchase p){
        Purchase purchase =purchaseService.findPurchasesByid(p);
        return ResponseEntity.ok(new BaseResult(0,"成功").append("data",purchase));

    }
    /**
     * 查询正在进行的采购信息
     */
    @GetMapping("/findBystate/{curr}")
    public ResponseEntity<BaseResult> findBystate(@PathVariable("curr") Integer curr){
        PageInfo<Purchase> bystate = purchaseService.findBystate(curr,0);
        return ResponseEntity.ok(new BaseResult(0,"成功").append("pagesize",bystate.getPages()).append("data",bystate.getList()));

    }
    /**
     * 查询结束的采购信息
     */
    @GetMapping("/findBystateEnd/{endcur}")
    public ResponseEntity<BaseResult> findBystateEnd(@PathVariable("endcur") Integer curr){
        PageInfo<Purchase> bystate = purchaseService.findBystate(curr,1);
        return ResponseEntity.ok(new BaseResult(0,"成功").append("pagesize",bystate.getPages()).append("data",bystate.getList()));

    }

}
