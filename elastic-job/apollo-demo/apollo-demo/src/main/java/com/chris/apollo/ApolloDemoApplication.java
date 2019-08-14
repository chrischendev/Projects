package com.chris.apollo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//如果默认命名空间为application，可以不带参数
@EnableApolloConfig("application-dev.yml")
public class ApolloDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApolloDemoApplication.class, args);
    }

}
