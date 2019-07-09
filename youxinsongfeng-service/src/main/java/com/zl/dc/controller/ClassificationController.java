package com.zl.dc.controller;

import com.zl.dc.entity.Classification;
import com.zl.dc.service.ClassificationService;
import com.zl.dc.vo.BaseResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: 舌頭會游泳
 * @Date: 2019/7/8 19:50
 * @Description:
 */

/**
 * 商品分类
 */
@RestController
@RequestMapping
public class ClassificationController {
    @Resource
    private ClassificationService classificationService;

    /**
     * 查询所有分类
     */
    @GetMapping("/findClassifications")
    public ResponseEntity<BaseResult> findClassifications(){
        List<Classification> classifications = classificationService.findClassifications();
        return ResponseEntity.ok(new BaseResult(0,"查询成功").append("data",classifications));
    }
}
