package com.chris.apollo;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by: Chris Chan
 * create on: 2019/8/6 11:14
 * use for:
 */
@RestController
@RequestMapping("/api")
public class ApolloApi {
//    @ApolloConfig
//    Config config;
    @Value("${name:chenfb}")
    String name;
    @Value("${address:HanzHong Nanzheng}")
    String address;

    @GetMapping("/name")
    public String getName() {
        return address + " : " + name;
    }
}
