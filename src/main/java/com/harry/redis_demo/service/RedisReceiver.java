package com.harry.redis_demo.service;

import org.springframework.stereotype.Service;

@Service
public class RedisReceiver {

    public void receiveMessage(String msg) {
        System.out.println("Message: " + msg);
    }
}
