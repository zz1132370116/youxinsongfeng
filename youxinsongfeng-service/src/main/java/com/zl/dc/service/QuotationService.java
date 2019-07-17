package com.zl.dc.service;

import com.zl.dc.entity.Classification;
import com.zl.dc.entity.Quotation;
import com.zl.dc.mapper.ClassificationMapper;
import com.zl.dc.mapper.QuotationMapper;
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

    /**
     * 条件查询(名称,规格)
     * @param quotation
     * @return
     */
    public List<Quotation> SearchQuotation(Quotation quotation) {
        Example example = new Example(Quotation.class);
        Example.Criteria criteria = example.createCriteria();
        if (quotation.getPhone() != null && quotation.getPhone().equals("")){
            criteria.andEqualTo("phone",quotation.getPhone());
        }
        if (quotation.getProductName() != null && quotation.getProductName().equals("")){
            criteria.andEqualTo("product_name",quotation.getProductName());
        }
        if (quotation.getSpecificationType() != null && quotation.getSpecificationType().equals("")){
            criteria.andEqualTo("specification_type",quotation.getSpecificationType());
        }
        List<Quotation> quotations = quotationMapper.selectByExample(example);
        for (Quotation quotation1 : quotations) {
            //通过商品名查询所对应的分类信息
            Classification classification =classificationMapper.selectClassByName(quotation1.getProductName());
            //通过父类id查询
            Classification classification1 = classificationMapper.selectClassByParent(classification.getClassificationParent());
            quotation1.setClassificationName(classification1.getClassificationName());
        }
        return quotations   ;
    }

    /**
     * 保存报价信息
     * @param quotation
     */
    public void SaveQuitation(Quotation quotation) {
        quotationMapper.insertSelective(quotation);
    }
}
