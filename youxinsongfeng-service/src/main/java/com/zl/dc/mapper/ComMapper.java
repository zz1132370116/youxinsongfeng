package com.zl.dc.mapper;

import com.zl.dc.entity.Com;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Auther: 舌頭會游泳
 * @Date: 2019/7/12 16:13
 * @Description:
 */
@org.apache.ibatis.annotations.Mapper
public interface ComMapper extends Mapper<Com> {
    @Select("select * from com where companyId = #{companyId}")
    List<Com> findByCompanyId(@Param("companyId") int companyId);
}
