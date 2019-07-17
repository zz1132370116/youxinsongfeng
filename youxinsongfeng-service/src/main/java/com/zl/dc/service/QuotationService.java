package com.zl.dc.service;

import com.zl.dc.entity.Quotation;
import com.zl.dc.mapper.QuotationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author pds
 */
@Service
@Transactional
public class QuotationService {
    @Autowired
    private QuotationMapper quotationMapper;

    public Quotation findOne(){
        Quotation quotation = (Quotation) quotationMapper.selectByPrimaryKey(1);
        return quotation;
    }
}
