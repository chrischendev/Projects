package com.chris.school.webasynctask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.text.SimpleDateFormat;
import java.util.concurrent.Callable;

/**
 * ChrisTechnologyDemo
 * com.chris.school.webasynctask
 * Created by Chris Chen
 * 2018/7/19
 * Explain:
 */
@RestController
@RequestMapping("/async")
@Slf4j
public class WebAsyncController {

    @RequestMapping("/test")
    public WebAsyncTask<String> test() {
        System.out.println(Thread.currentThread().getId() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(System.currentTimeMillis()));
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() {
                long threadId = Thread.currentThread().getId();
                ThreadLocal<String> threadLocal = new ThreadLocal<>();
                threadLocal.set(threadId + "");
                try {
                    Thread.sleep(4 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return threadLocal.get() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(System.currentTimeMillis());
            }
        };
        return new WebAsyncTask<>(callable);
    }
}
