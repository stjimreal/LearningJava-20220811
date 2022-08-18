package com.example.LearnException.service;

import com.example.LearnException.dao.IUserDao;
import com.example.LearnException.model.Jduser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: Learning-20220811
 * @description:
 * @author:
 * @created: 2022/08/17 19:52
 */

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    IUserDao userDao;

    @Override
    public Jduser createUser(Jduser jduser) {
        return userDao.save(jduser);
    }

    @Override
    public void deleteUser(Integer uid) {
        userDao.deleteById(uid);
    }

    @Override
    public Iterable<Jduser> listUsers() {
        return userDao.findAll();
    }
}
