package com.demo.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "测试接口")
public class TestController {

    @PostMapping("/test")
    @ApiOperation("测试接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "test1", value = "测试1", defaultValue = "测试1"),
            @ApiImplicitParam(name = "test2", value = "测试2", required = true)}  )
    public String test(@RequestParam("test1")String test1, @RequestParam("test2") String test2){
        return test1+"----"+test2;
    }

}
