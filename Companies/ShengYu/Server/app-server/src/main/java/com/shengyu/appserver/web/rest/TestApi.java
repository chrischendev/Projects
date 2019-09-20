package com.shengyu.appserver.web.rest;

import com.shengyu.appserver.security.SecurityUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by: Chris Chan
 * create on: 2019/9/19 2:42
 * use for:
 */
@RestController
@RequestMapping("/api")
public class TestApi {
    @GetMapping("/test")
    public ResponseEntity<?> test() {
        //从JWT中解析出用户名
        String username = SecurityUtils.getCurrentUserLogin().get();
        return ResponseEntity.ok("api-test-success: "+username);
    }
}
