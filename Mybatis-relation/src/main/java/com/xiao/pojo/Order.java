package com.xiao.pojo;

import java.util.Date;

/**
 * @ClassName : Order  //类名
 * @Description : 订单表  //描述
 * @Author : Xiaodayong  //作者
 * @Date: 2020-11-01 10:52  //时间
 */
public class Order {

    private Integer id;
    private String title;
    private Date orderTime;

    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", orderTime=" + orderTime +
                ", user=" + user +
                '}';
    }
}
