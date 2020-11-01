package com.xiao.dao;

import com.xiao.pojo.Order;

import java.util.List;

public interface IOrderMapper {

    List<Order> findOrderByUser();

}
