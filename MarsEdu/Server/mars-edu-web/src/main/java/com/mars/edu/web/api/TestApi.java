package com.mars.edu.web.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Chris Chan
 * Create on 2019/5/30 10:21
 * Use for:
 */
@RestController
@RequestMapping("/api/v1/school")
@Api(value = "test", tags = "school", description = "学校 测试接口")
public class TestApi {
    @GetMapping("/test")
    @ApiOperation(value = "test", tags = "school", notes = "测试接口", httpMethod = "GET")
    public String test() {
        return "Query school success.";
    }
}
