package com.mars.edu.web.config.enhance;

import com.chris.framework.builder.net.protocol.NetResult;
import com.chris.framework.builder.utils.ResultUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chrischan
 * create on 2019/7/10 14:17
 * use for: 统一异常处理
 */
@ControllerAdvice
public class CommonExceptionHandler {
    /**
     * 统一异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public NetResult handleException(RuntimeException e) {
        e.printStackTrace();
        return ResultUtils.buildError(e.getMessage());
    }


}
