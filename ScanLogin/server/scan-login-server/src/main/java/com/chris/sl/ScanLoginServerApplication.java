package com.chris.sl;

import com.chris.sl.manager.DataManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScanLoginServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScanLoginServerApplication.class, args);
        DataManager.init();
    }

}
