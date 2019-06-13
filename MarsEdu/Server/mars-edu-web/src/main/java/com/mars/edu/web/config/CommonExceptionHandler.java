package com.mars.edu.web.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Chris Chen
 * 2017/9/18
 * Explain:异常统一处理
 */
@ControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity<?> handleException(RuntimeException e) {
        e.printStackTrace();
        return ResponseEntity.ok().build();
    }
}
