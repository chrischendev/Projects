package com.chris.lts;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * create by: Chris Chan
 * create on: 2019/7/31 8:05
 * use for:
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class LtsApi {

    @GetMapping("/excute")
    public void excute() {
        String timeStr = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        log.info("定时器执行了~~~ {} {}", timeStr, "呵呵");
        try {
            //IOUtils.write("执行了~~~ " + timeStr, new FileOutputStream("D:\\io-test.txt"), Charset.forName("UTF-8"));
            FileUtils.write(new File("D:\\io-test.txt"), "执行了~~~ " + timeStr +"\r\n", Charset.forName("UTF-8"), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
