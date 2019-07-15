package com.zl.dc.controller;

import com.zl.dc.entity.Company;
import com.zl.dc.service.CompanyService;
import com.zl.dc.vo.BaseResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: 舌頭會游泳
 * @Date: 2019/7/12 16:07
 * @Description:
 */
@RestController
@RequestMapping
public class CompanyController {
    @Resource
    private CompanyService companyService;
    /**
     * 资源-查询
     */
    @GetMapping("/findAllResources")
    public ResponseEntity<BaseResult> findAllResources(){
        List<Company> companies = companyService.findAllResources();
        return ResponseEntity.ok(new BaseResult(0,"查询成功").append("data",companies));
    }
}
