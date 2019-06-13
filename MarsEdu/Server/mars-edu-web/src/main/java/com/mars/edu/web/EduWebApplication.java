package com.mars.edu.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class EduWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduWebApplication.class, args);
    }

}
