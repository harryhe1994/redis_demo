package com.harry.redis_demo.service;

import com.harry.redis_demo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    private RedisUtil redisUtil;

    public boolean setValue(String key, Object value) {
        return  redisUtil.set(key, value);
    }

    public String getValue(String key) {
        return String.valueOf(redisUtil.get(key));
    }

    public long getExpire(String key) {
        return redisUtil.getExpire(key);
    }

    public boolean setExpire(String key) {
        return redisUtil.expire(key, 30L);
    }
}
