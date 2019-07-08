package com.zl.dc.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.netflix.ribbon.proxy.annotation.Http;
import com.zl.dc.config.PreReadUploadConfig;
import com.zl.dc.config.SmsUtil;
import com.zl.dc.entity.UserEntity;
import com.zl.dc.service.UserService;
import com.zl.dc.vo.BaseResult;
import org.apache.catalina.LifecycleState;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;
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
    @Autowired
    PreReadUploadConfig uploadConfig;

    /**
     * 通过手机号和密码进行查询
     *
     * @param userEntity
     * @return
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

    @PostMapping("/sms")
    public ResponseEntity<BaseResult> sendSms(@RequestBody UserEntity user) {
        try {
            //发送短信
            //1 生产验证码
            String code = RandomStringUtils.randomNumeric(4);

            //2 并存放到reids中 , key:手机号 ， value：验证码 , 1小时
            redisTemplate.opsForValue().set(user.getPhone(), code, 5, TimeUnit.MINUTES);

            //3 发送短信
            SendSmsResponse smsResponse = SmsUtil.sendSms(user.getPhone(), code);

            //https://help.aliyun.com/document_detail/55284.html?spm=5176.doc55322.6.557.KvvIJx
            if ("OK".equalsIgnoreCase(smsResponse.getCode())) {
                return ResponseEntity.ok(new BaseResult(0, "发送成功"));
            } else {
                return ResponseEntity.ok(new BaseResult(0, smsResponse.getMessage()));
            }

        } catch (ClientException e) {
            e.printStackTrace();
            return ResponseEntity.ok(new BaseResult(1, "发送失败"));
        }
    }

    @PostMapping("/regist")
    public ResponseEntity<BaseResult> regist(@RequestBody UserEntity user) {
        try {
            Set<String> keys = redisTemplate.keys(user.getPhone());
            for (String key : keys) {
                if (key.equals(user.getCode())) {
                    //保存
                    String s = userService.saveUser(user);
                    if (s.equals("添加成功")) {
                        //提示成功
                        return ResponseEntity.ok(new BaseResult(0, "注册成功"));
                    } else if (s.equals("添加失败")) {
                        return ResponseEntity.ok(new BaseResult(1, "注册失败,已有账号"));
                    }
                } else {
                    return ResponseEntity.ok(new BaseResult(1, "验证码输入错误或已超时"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new BaseResult(1, "注册失败"));
        }

        return null;
    }

    /**
     * 根据手机获取用户信息 ----- member.基本会员.基本信息.html
     *
     * @param user
     * @return
     */
    @PostMapping("/getUserByPhone")
    public ResponseEntity<BaseResult> findUserByPhone(@RequestBody UserEntity user) {
        try {
            //根据手机获取用户信息
            UserEntity userEntity = this.userService.findByMobile(user.getPhone());
            return ResponseEntity.ok(new BaseResult(0, "获取用户信息成功").append("data", userEntity));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new BaseResult(1, "获取用户信息失败"));
        }
    }

    /**
     * 上传图片 -----  member.基本会员.基本信息.html
     *
     * @param file
     * @return
     */
    @PostMapping("/uploadImage")
    public ResponseEntity<BaseResult> uploadImage(@RequestParam("file") MultipartFile file) {
        String saveFilePath = "";
        String savedFileName = "";
        if (!file.isEmpty()) {
            //获得原始文件名;
            String fileRealName = file.getOriginalFilename();
            //点号的位置
            int pointIndex = fileRealName.indexOf(".");
            //截取文件后缀
            String fileSuffix = fileRealName.substring(pointIndex);
            Random random = new Random();
            String picTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + random.nextInt(10000);
            savedFileName = picTime.concat(fileSuffix);
            System.out.println(savedFileName);

            //获取服务器指定文件存取路径
            //saveFilePath = request.getSession().getServletContext().getRealPath("headicon");
            //String path = this.getClass().getClassLoader().getResource("").getPath();
            //System.out.println(path);
            //saveFilePath = "src/main/resource/static/headicon";
            saveFilePath = uploadConfig.getUploadPath();
            System.out.println(saveFilePath);

            /* 构建文件目录 */
            File fileDir = new File(saveFilePath);
            if (!fileDir.exists()) {
                fileDir.mkdirs();
            }
            try {
                FileOutputStream out = new FileOutputStream(saveFilePath + "\\" + savedFileName);
                // 写入文件
                out.write(file.getBytes());
                out.flush();
                out.close();

            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.ok(new BaseResult(1, "图片上传失败"));
            }
        }else {
            return ResponseEntity.ok(new BaseResult(1, "图片上传失败"));
        }
        return ResponseEntity.ok(new BaseResult(0, "图片上传成功").append("image","/headicon"+"\\"+savedFileName));
    }

    /**
     * 修改用户信息 -----  member.基本会员.基本信息.html
     * @param userEntity
     * @return
     */
    @PostMapping("/changeUserInfo")
    public ResponseEntity<BaseResult> changeUserInfo(@RequestBody UserEntity userEntity){
        //修改用户信息
        int updateStatus = this.userService.updateUser(userEntity);
        //判断是否修改成功，修改成功则重新查询
        if(updateStatus == 1){
            UserEntity user = this.userService.findByMobile(userEntity.getPhone());
            return ResponseEntity.ok(new BaseResult(0, "修改成功").append("data", user));
        }
        //不成功则返回修改失败
        return ResponseEntity.ok(new BaseResult(1, "修改失败"));
    }
}
