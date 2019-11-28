package com.cyt.dao;

import com.cyt.domain.User;
import java.util.List;

public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 查询单个用户
     * @return
     */
    User findUserById(Integer id);
}
