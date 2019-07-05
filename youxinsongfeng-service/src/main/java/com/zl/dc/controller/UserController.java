package com.zl.dc.controller;

import com.zl.dc.entity.UserEntity;
import com.zl.dc.service.UserService;
import org.apache.catalina.LifecycleState;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: 舌頭會游泳
 * @Date: 2019/7/5 16:45
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {
@Resource
private UserService userService;
    /**
     * 通过手机号和密码进行查询
     * @param mobile
     * @param password
     * @return
     */
    @GetMapping("/query")
    public ResponseEntity<UserEntity> queryUser(@RequestParam("mobile") String mobile , @RequestParam("password") String password){
        //1 通过手机号查询用户
        UserEntity user = this.userService.findByMobile( mobile );
        //2 判断密码是否正确
        if(user == null || !user.getPassword().equals(password)){
            //密码不对
            return ResponseEntity.ok( null );
        }
        System.out.println("aaaaa");
        //3 正确
        return ResponseEntity.ok( user );
    }
    public void selectALl(){
        List<UserEntity> userEntities = userService.selectAll();
        for (UserEntity userEntity : userEntities) {
            System.out.println(userEntity);
        }
    }

}
