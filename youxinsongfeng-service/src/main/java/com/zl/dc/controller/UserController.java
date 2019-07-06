package com.zl.dc.controller;

import com.netflix.ribbon.proxy.annotation.Http;
import com.zl.dc.entity.UserEntity;
import com.zl.dc.service.UserService;
import com.zl.dc.vo.BaseResult;
import org.apache.catalina.LifecycleState;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Auther: 舌頭會游泳
 * @Date: 2019/7/5 16:45
 * @Description:
 */
@RestController
@RequestMapping
public class UserController {
    @Resource
    private UserService userService;
    @Autowired
    HttpServletRequest request;
    /**
     * 通过手机号和密码进行查询
     * @param userEntity
     *
     * @return
     */
    @PostMapping("/query")
    public ResponseEntity<BaseResult> queryUser(@RequestBody UserEntity userEntity){
        //1 通过手机号查询用户
        UserEntity user = this.userService.findByMobile( userEntity.getPhone() );
        //2 判断密码是否正确
        if(user == null || !user.getPassword().equals(userEntity.getPassword())){
            //密码不对
            return ResponseEntity.ok( null );
        }
        //3 正确
        return ResponseEntity.ok( new BaseResult(0,"登录成功").append("data",user) );
    }

}
