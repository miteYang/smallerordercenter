package com.demo.user.controller;

import com.demo.user.entity.TbProject;
import com.demo.user.impl.PeoImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@Api(tags = "用户接口")
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private PeoImpl peoImpl;

    @GetMapping("/getMessage")
    @ApiOperation("获取message")
    public String getMessage() {
        String str = "节点";
        for(int i=1;i<=100;i++){
//            System.out.println(str+i);
            System.out.println(i);
        }
        return "hello, I am client.";
    }

    @PostMapping("/getPeo")
    @ApiOperation("获取树状菜单数据")
    public String getPro(@RequestBody TbProject project) throws IOException {
        return peoImpl.selectTree(project);
//        return "hello, I am client.";
    }

    @GetMapping("/getMqMessage")
    @ApiOperation("获取MqMessage")
    public String getMqMessage() {

        return peoImpl.getMqMessage();
    }
}
