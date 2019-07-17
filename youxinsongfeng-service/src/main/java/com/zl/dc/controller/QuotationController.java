package com.zl.dc.controller;

import com.zl.dc.entity.Quotation;
import com.zl.dc.entity.Warehouse;
import com.zl.dc.service.QuotationService;
import com.zl.dc.vo.BaseResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author pds
 */
@RestController
@RequestMapping
public class QuotationController {
    @Resource
    private QuotationService quotationService;

    /**
     * 条件查询当前用户所保存的报价单
     */
    @PostMapping("/searchQuotation")
    public ResponseEntity<BaseResult> SearchQuotation(@RequestBody Warehouse quotation){
        if (quotation != null){
            List<Warehouse> warehouses = quotationService.SearchQuotation(quotation);
            return ResponseEntity.ok(new BaseResult(0,"查询成功").append("data",warehouses));
        }else{
            return ResponseEntity.ok(new BaseResult(1,"失败"));
        }
    }
    /**
     *
     */
    @PostMapping("/saveQuitation")
    public ResponseEntity<BaseResult> SaveQuitation(@RequestBody Quotation quotation){
        if (quotation != null){
           quotationService.SaveQuitation(quotation);
            return ResponseEntity.ok(new BaseResult(0,"保存成功"));
        }else{
            return ResponseEntity.ok(new BaseResult(1,"失败"));
        }
    }
}
