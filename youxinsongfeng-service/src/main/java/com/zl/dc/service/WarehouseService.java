package com.zl.dc.service;

import com.zl.dc.mapper.WarehouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WarehouseService {
    @Autowired
    private WarehouseMapper warehouseMapper;


}
