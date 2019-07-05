package com.zl.dc.service;

import com.zl.dc.entity.UserEntity;
import com.zl.dc.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

/**
 * @author 舌頭會游泳
 * @Auther: 舌頭會游泳
 * @Date: 2019/7/5 16:46
 * @Description:
 */
@Service
@Transactional
public class UserService {
    @Autowired
    private UserMapper userMapper;


    /**
     * 通过手机号查询
     * @param mobile
     * @return
     */
    public UserEntity findByMobile(String mobile){
        //1 拼凑条件
        Example example = new Example(UserEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("mobile" , mobile );
        //2 查询
        return this.userMapper.selectOneByExample( example );
    }

}
