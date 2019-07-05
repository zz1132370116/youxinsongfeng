package com.zl.dc.client;

import com.zl.dc.entity.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author 舍頭襘游泳
 * @date 2018/12/13
 */

@FeignClient("web-service")
// @Component
public interface UserClient {
    @GetMapping("query")
    ResponseEntity<UserEntity> queryUser(@RequestParam("phone") String mobile,
                                         @RequestParam("password") String password);
}