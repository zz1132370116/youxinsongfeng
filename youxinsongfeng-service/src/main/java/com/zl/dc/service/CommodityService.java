package com.zl.dc.service;

import com.zl.dc.entity.Commodity;
import com.zl.dc.mapper.CommodityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Auther: 舌頭會游泳
 * @Date: 2019/7/11 16:16
 * @Description:
 */
@Service
@Transactional
public class CommodityService {
    @Autowired
    private CommodityMapper commodityMapper;

    /**
     * 条件查询
     * @param commodity
     * @return
     */
    public List<Commodity> search(Commodity commodity) {
        //拼接条件
        Example example = new Example(Commodity.class);
        Example.Criteria criteria = example.createCriteria();
        if (commodity.getCommodityName() !=null && commodity.getCommodityName() != ""){
            criteria.andEqualTo("commodityName",commodity.getCommodityName());
        }
        if (commodity.getCommodityPlace()!=null && commodity.getCommodityPlace() != ""){
            criteria.andEqualTo("commodityPlace",commodity.getCommodityPlace());
        }
        if (commodity.getCommodityLevel() !=null && commodity.getCommodityLevel() != ""){
            criteria.andEqualTo("commodityLevel",commodity.getCommodityLevel());
        }
        if (commodity.getCommodityWarehouse() !=null && commodity.getCommodityWarehouse() != ""){
            criteria.andEqualTo("commodityWarehouse",commodity.getCommodityWarehouse());
        }
        if (commodity.getCommoditySport() !=null && commodity.getCommoditySport() != ""){
            criteria.andEqualTo("commoditySport",commodity.getCommoditySport());
        }
        if (commodity.getCommoditySpecification() !=null && commodity.getCommoditySpecification() != ""){
            criteria.andEqualTo("commoditySpecification",commodity.getCommoditySpecification());
        }
        return commodityMapper.selectByExample(example);
    }

    public Commodity findCommoditityById(Commodity commodity){
        Commodity commodity1 = commodityMapper.selectByPrimaryKey(commodity.getCommodityId());

        return commodity1;
    }
}
