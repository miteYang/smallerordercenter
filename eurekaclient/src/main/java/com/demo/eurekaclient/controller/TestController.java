package com.demo.eurekaclient.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "测试接口")
@RequestMapping(value = "user")
public class TestController {

    @GetMapping("/getMessage")
    @ApiOperation("测试接口")
    public String getMessage() {
        String version = SpringVersion.getVersion();
        String version1 = SpringBootVersion.getVersion();
        return "hello, I am client."+version+"--"+version1;
    }
}
