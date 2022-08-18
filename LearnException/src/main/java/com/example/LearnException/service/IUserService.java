package com.example.LearnException.service;

import com.example.LearnException.model.Jduser;
import org.springframework.stereotype.Service;

public interface IUserService {
    /**
     * 创建用户
     * @param jduser
     * @return Jduser
     */
    Jduser createUser(Jduser jduser);

    /**
     * 删除用户
     * @param uid
     */
    void deleteUser(Integer uid);

    /**
     * 查询所有用户
     *
     * @return List<Jduser>
     */
    Iterable<Jduser> listUsers();
}
