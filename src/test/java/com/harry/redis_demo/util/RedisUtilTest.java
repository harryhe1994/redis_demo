package com.harry.redis_demo.util;

import com.harry.redis_demo.RedisDemoApplication;
import com.harry.redis_demo.service.RedisService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RedisDemoApplication.class)
public class RedisUtilTest {

    @Autowired
    private RedisService redisService;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 正常设值
     */
    @Test
    public void setValue() {
        Assert.assertTrue(redisService.setValue("key1", "Harry He"));
    }

    @Test
    public void getValue() {
        Assert.assertEquals("Harry He", redisService.getValue("key1"));
    }

    /**
     * 设置过期时间
     */
    @Test
    public void setExpire() {
        redisUtil.expire("key1", 30L);
    }

    /**
     * 普通存入并且设定时间
     */

    @Test
    public void setValueAndExpire() {
        redisUtil.set("key2", "Key2 Test", 30L);
    }

    @Test
    public void test_incr() {
        redisUtil.incr("num", 4L);
    }

    @Test
    public void test_decr() {
        redisUtil.decr("num", 4L);
    }

    /**
     * map
     */
    @Test
    public void test_set_value_to_map() {
        redisUtil.hset("s1", "name", "Harry");
    }

    @Test
    public void test_get_value_from_map() {
        Assert.assertEquals("Harry", redisUtil.hget("s1", "name"));
    }

    @Test
    public void test_delete_hash_set_value() {
        redisUtil.hdel("s1", "name");
    }

    @Test
    public void test_has_key() {
        Assert.assertTrue(redisUtil.hHasKey("s1", "name"));
    }

    /**
     * Set
     */
    @Test
    public void test_set_for_hashSet() {
        redisUtil.sSet("name1", "harry", "value");
    }

    @Test
    public void test_sGetSetSize() {
        Assert.assertEquals(2, redisUtil.sGetSetSize("name1"));
    }

    /**
     * list
     */
    @Test
    public void test_list_set() {
        redisUtil.lSet("mylist", "Harry He");
    }

    @Test
    public void test_list_get() {
        List<Object> list = redisUtil.lGet("mylist", 0, -1);
        Assert.assertEquals("Harry He", list.get(0));
    }

    /**
     * send message
     */
    @Test
    public void sendMessage() {
        redisTemplate.convertAndSend("index", String.valueOf(Math.random()));
    }
}