package com.zl.dc.controller;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.zl.dc.config.PreReadUploadConfig;
import com.zl.dc.config.SmsUtil;
import com.zl.dc.config.SmsUtil2;
import com.zl.dc.entity.UserEntity;
import com.zl.dc.service.UserService;
import com.zl.dc.vo.BaseResult;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
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
     * 发短信
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

    /**
     * 根据手机获取用户信息 ----- member.基本会员.基本信息.html
     *
     * @param user
     * @return
     */
    @PostMapping("/getUserByPhone")
    public ResponseEntity<BaseResult> getUserByPhone(@RequestBody UserEntity user) {
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
     * 修改密码
     * @param userEntity
     * @return
     * @auther zhanglei
     */
    @PostMapping("/updatePassword")
    public ResponseEntity<BaseResult>updatePassword(@RequestBody UserEntity userEntity){
        userService.updatePassword(userEntity);

        return ResponseEntity.ok(new BaseResult(0,"修改成功"));
    }
    /**
     * 发短信
     * @param user
     * @return
     * @auther zhanglei
     */
    @PostMapping("/sms2")
    public ResponseEntity<BaseResult> sendSms2(@RequestBody UserEntity user) {
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
                SendSmsResponse smsResponse = SmsUtil2.sendSms(user.getPhone(), code);
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
