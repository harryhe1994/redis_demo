package com.harry.redis_demo.repository;

import com.harry.redis_demo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void test_insert() {
        User user = new User();
        user.setName("Tom");
        user.setAge(20);
        userDao.save(user);
    }
}