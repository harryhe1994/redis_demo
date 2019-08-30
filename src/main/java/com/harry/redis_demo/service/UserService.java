package com.harry.redis_demo.service;

import com.harry.redis_demo.model.User;
import com.harry.redis_demo.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUser(Long id) {
        return userDao.findById(id).get();
    }


    public List<User> getAll() {
        return userDao.findAll();
    }

    @Transactional
    public User save(User user) {
        return userDao.save(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        userDao.deleteById(id);
    }

    @Transactional
    public User update(User user) {
        Optional<User> u = userDao.findById(user.getId());
        u.get().setAge(user.getAge());
        u.get().setName(user.getName());
        return userDao.save(u.get());
    }
}
