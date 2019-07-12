package com.zl.dc.service;

import com.zl.dc.entity.Com;
import com.zl.dc.entity.Commodity;
import com.zl.dc.entity.Company;
import com.zl.dc.mapper.ComMapper;
import com.zl.dc.mapper.CommodityMapper;
import com.zl.dc.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Auther: 舌頭會游泳
 * @Date: 2019/7/12 16:10
 * @Description:
 */
@Service
@Transactional
public class CompanyService {
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private CommodityMapper commodityMapper;
    @Autowired
    private ComMapper comMapper;

    public List<Company> findAllResources() {
        Example example = new Example(Commodity.class);
        Example.Criteria criteria = example.createCriteria();
        //查询所有公司
        List<Company> companies = companyMapper.selectAll();
        if (companies !=null){
            for (Company company : companies) {
                //从中间表中查询商品信息
                List<Com> byCompanyId = comMapper.findByCompanyId(company.getCompanyId());
                for (Com com : byCompanyId) {
                    //查询商品信息
                    criteria.andEqualTo("commodityId",com.getCommodityId());
                    List<Commodity> commodities = commodityMapper.selectByExample(example);
                    company.setCommodities(commodities);
                }
            }
        }
        return companies;
    }
}
