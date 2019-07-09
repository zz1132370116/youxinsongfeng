package com.zl.dc.mapper;

import com.zl.dc.entity.Classification;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Auther: 舌頭會游泳
 * @Date: 2019/7/8 19:51
 * @Description:
 */
@org.apache.ibatis.annotations.Mapper
public interface ClassificationMapper extends Mapper<Classification> {
}
