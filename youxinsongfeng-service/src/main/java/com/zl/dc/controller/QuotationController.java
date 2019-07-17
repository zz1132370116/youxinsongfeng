package com.zl.dc.controller;

import com.zl.dc.entity.Quotation;
import com.zl.dc.service.QuotationService;
import com.zl.dc.vo.BaseResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author pds
 */
@RestController
@RequestMapping
public class QuotationController {
    @Resource
    private QuotationService quotationService;

    @GetMapping("/findOne")
    public ResponseEntity<BaseResult> findOne(){
        Quotation quotation = quotationService.findOne();
        return ResponseEntity.ok(new BaseResult(0,"查询成功").append("data",quotation));
    }
}
