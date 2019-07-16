package com.zl.dc.service;

import com.zl.dc.entity.Purchase;
import com.zl.dc.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Auther: 舌頭會游泳
 * @Date: 2019/7/16 10:34
 * @Description:
 */
@Service
@Transactional
public class PurchaseService {
    @Autowired
    private PurchaseMapper purchaseMapper;

    public List<Purchase> findAllPurchases() {
        Example example = new Example(Purchase.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andNotEqualTo("state",1);
        List<Purchase> list = purchaseMapper.selectByExample(example);
        return list;
    }

    public void savePurchase(Purchase purchase){
        purchaseMapper.insert(purchase);
    }
}
