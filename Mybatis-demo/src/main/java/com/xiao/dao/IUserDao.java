package com.xiao.dao;

import com.xiao.pojo.User;

import java.lang.reflect.Array;
import java.util.List;

public interface IUserDao {

    List<User> findAll ();

    User findByCondition (User user);

    List<User> findByIds(int[] ids);
}
