package com.zl.dc.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zl.dc.entity.Purchase;
import com.zl.dc.mapper.PurchaseMapper;
import com.zl.dc.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
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

    /**
     * 查询所有采购信息
     * @return
     */
    public PageInfo<Purchase> findAllPurchases( Integer cur) {

        PageHelper.startPage(cur, 5);
        List<Purchase> list = purchaseMapper.selectAll();
        PageInfo<Purchase> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }

    /**
     * 通过id查询详情
     * @param p
     * @return
     */
    public Purchase findPurchasesByid(Purchase p) {
        System.out.println(p);
        return purchaseMapper.selectByPrimaryKey(p.getPurchaseId());
    }

    public PageInfo<Purchase> findBystate(Integer curr,Integer state) {
        PageHelper.startPage(curr, 5);
        Example example = new Example(Purchase.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("state",state);
        List<Purchase> list = purchaseMapper.selectByExample(example);
        PageInfo<Purchase> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

}
