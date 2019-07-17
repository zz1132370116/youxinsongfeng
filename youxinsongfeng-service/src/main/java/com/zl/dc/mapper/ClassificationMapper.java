package com.zl.dc.mapper;

import com.zl.dc.entity.Classification;
import org.apache.ibatis.annotations.Param;
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

    @Select("select * from classification where Classification_name = #{Classification_name}")
    Classification selectClassByName(@Param("Classification_name") String classificationName);

    @Select("select * from classification where classification_id = #{classification_parent}")
    Classification selectClassByParent(@Param("classification_parent") String classificationParent);
}
