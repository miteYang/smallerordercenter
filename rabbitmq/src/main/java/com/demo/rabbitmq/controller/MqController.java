package com.demo.rabbitmq.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "MQ接口")
@RequestMapping(value = "/mq")
public class MqController {

    @GetMapping("/getMessage")
    @ApiOperation("获取message")
    public String getMessage() {
        String str = "节点";
        return "hello, I am client."+str;
    }
}
