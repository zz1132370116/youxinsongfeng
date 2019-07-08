package com.zl.dc.controller;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.zl.dc.config.SmsUtil;
import com.zl.dc.entity.UserEntity;
import com.zl.dc.service.UserService;
import com.zl.dc.vo.BaseResult;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

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
    @Resource
    private StringRedisTemplate redisTemplate;

    /**
     * 通过手机号和密码进行查询
     *
     * @param userEntity
     * @return
     * @auther zhanglei
     */
    @PostMapping("/query")
    public ResponseEntity<BaseResult> queryUser(@RequestBody UserEntity userEntity) {
        //1 通过手机号查询用户
        UserEntity user = this.userService.findByMobile(userEntity.getPhone());
        //2 判断密码是否正确
        if (user == null || !user.getPassword().equals(userEntity.getPassword())) {
            //密码不对
            return ResponseEntity.ok(null);
        }
        //3 正确
        return ResponseEntity.ok(new BaseResult(0, "登录成功").append("data", user));
    }

    /**
     * @param user
     * @return
     * @auther zhanglei
     */
    @PostMapping("/sms")
    public ResponseEntity<BaseResult> sendSms(@RequestBody UserEntity user) {
        try {
            //发送短信
            //1 生产验证码
            String code = RandomStringUtils.randomNumeric(4);
            //2 并存放到reids中 , key:手机号 ， value：验证码 , 1小时
            String s = redisTemplate.opsForValue().get(user.getPhone());
            if (s == null || s.equals("")) {
                redisTemplate.opsForValue().set(user.getPhone(), code, 5, TimeUnit.MINUTES);
                System.out.println("手机验证码为:"+code);
                //3 发送短信
                SendSmsResponse smsResponse = SmsUtil.sendSms(user.getPhone(), code);
                //https://help.aliyun.com/document_detail/55284.html?spm=5176.doc55322.6.557.KvvIJx
                if ("OK".equalsIgnoreCase(smsResponse.getCode())) {
                    return ResponseEntity.ok(new BaseResult(0, "发送成功"));
                } else {
                    return ResponseEntity.ok(new BaseResult(0, smsResponse.getMessage()));
                }

            } else {
                return ResponseEntity.ok(new BaseResult(0, "请稍后再点"));
            }


        } catch (ClientException e) {
            e.printStackTrace();
            return ResponseEntity.ok(new BaseResult(1, "发送失败"));
        }
    }

    /**
     * 注册
     *
     * @param user
     * @return
     * @auther zhanglei
     */
    @PostMapping("/regist")
    public ResponseEntity<BaseResult> regist(@RequestBody UserEntity user) {
        try {
            if (user.getPhone() != null) {
                //通过手机号获取验证码
                String s = redisTemplate.opsForValue().get(user.getPhone());
                //通过手机号查询
                UserEntity byMobile = this.userService.findByMobile(user.getPhone());
                //用户是否存在
                if (byMobile == null) {
                    //校验手机验证码
                    if (user.getCode().equals(s)) {
                        userService.saveUser(user);
                        return ResponseEntity.ok(new BaseResult(0, "注册成功"));
                    }
                }
            } else {
                return ResponseEntity.ok(new BaseResult(1, "该手机号已注册"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new BaseResult(1, "注册失败"));
        }
        return null;
    }

    @PostMapping("/getUserByPhone")
    public ResponseEntity<BaseResult> getUserByPhone(@RequestBody UserEntity user) {
        try {
            UserEntity userEntity = this.userService.findByMobile(user.getPhone());
            return ResponseEntity.ok(new BaseResult(0, "获取用户信息成功").append("data", userEntity));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new BaseResult(1, "获取用户信息失败"));
        }
    }
}
