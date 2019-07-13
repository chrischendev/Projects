package com.mars.edu.web;

import com.chris.gradle.ChrisGradleTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EduWebApplicationTests {

    @Test
    public void contextLoads() {
        ChrisGradleTest.call();
    }

}
