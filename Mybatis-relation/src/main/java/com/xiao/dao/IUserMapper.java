package com.xiao.dao;

import com.xiao.pojo.Role;
import com.xiao.pojo.User;

import java.util.List;

public interface IUserMapper {

    List<User> findUserByOrder();

    List<User> findUserByRole();

}
