package com.zl.dc.mapper;

import com.zl.dc.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 舌頭會游泳
 * @Date: 2019/7/5 16:47
 * @Description:
 */
@Mapper
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<UserEntity> {
}
