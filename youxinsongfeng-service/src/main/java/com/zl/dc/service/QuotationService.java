package com.zl.dc.service;

import com.zl.dc.entity.Classification;
import com.zl.dc.entity.Quotation;
import com.zl.dc.entity.Warehouse;
import com.zl.dc.mapper.ClassificationMapper;
import com.zl.dc.mapper.QuotationMapper;
import com.zl.dc.mapper.WarehouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author pds
 */
@Service
@Transactional
public class QuotationService {
    @Autowired
    private QuotationMapper quotationMapper;
    @Autowired
    private ClassificationMapper classificationMapper;
    @Autowired
    private WarehouseMapper warehouseMapper;

    /**
     * 条件查询(名称,规格)
     * @param quotation
     * @return
     */
    public List<Warehouse> SearchQuotation(Warehouse quotation) {
        Example example = new Example(Warehouse.class);
        Example example1 = new Example(Classification.class);
        Example.Criteria criteria = example.createCriteria();
        Example.Criteria criteria1 = example1.createCriteria();
        if (quotation.getPhone() != null && quotation.getPhone().equals("")){
            criteria.andEqualTo("phone",quotation.getPhone());
        }
        if (quotation.getProductName() != null && quotation.getProductName().equals("")){
            criteria.andEqualTo("product_name",quotation.getProductName());
        }
        if (quotation.getSpecificationType() != null && quotation.getSpecificationType().equals("")){
            criteria.andEqualTo("specification_type",quotation.getSpecificationType());
        }
        List<Warehouse> warehouse = warehouseMapper.selectByExample(example);
        for (Warehouse warehouse1 : warehouse) {
            //通过商品名查询所对应的分类信息
            criteria1.andEqualTo("classificationName",warehouse1.getProductName());

            Classification classification = classificationMapper.selectOneByExample(example1);
            if (classification !=null){
                Classification classification1 = classificationMapper.selectByPrimaryKey(classification.getClassificationParent());
                if (classification1 !=null){
                    warehouse1.setClassificationName(classification1.getClassificationName());
                }
            }


        }
        return warehouse ;
    }

    /**
     * 保存报价信息
     * @param quotation
     */
    public void SaveQuitation(Quotation quotation) {
        quotationMapper.insertSelective(quotation);
    }
}
