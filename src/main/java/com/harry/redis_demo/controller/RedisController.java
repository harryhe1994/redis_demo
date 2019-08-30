package com.harry.redis_demo.controller;

import com.harry.redis_demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;

    @GetMapping("hello")
    public String hello() {
        if (redisService.setValue("test1", "harry1")) {
            return "success";
        }
        return "fail";
    }

    @GetMapping("getValue")
    public String getValue (){
        return redisService.getValue("test1");
    }

    @GetMapping("getExpire")
    public long getExpire (){
        return redisService.getExpire("test1");
    }

    @GetMapping("setExpire")
    public boolean setExpire (){
        return redisService.setExpire("test1");
    }
}
