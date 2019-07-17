package com.zl.dc.controller;

import com.zl.dc.service.WarehouseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping
public class WarehouseController {
    @Resource
    private WarehouseService warehouseService;


}
