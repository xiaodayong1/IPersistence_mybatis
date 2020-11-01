package com.xiao.test;

import com.xiao.dao.IOrderMapper;
import com.xiao.dao.IUserMapper;
import com.xiao.pojo.Order;
import com.xiao.pojo.Role;
import com.xiao.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName : testRelation  //类名
 * @Description : 测试Mybatis复杂映射  //描述
 * @Author : Xiaodayong  //作者
 * @Date: 2020-11-01 11:35  //时间
 */
public class testRelation {

    // 一对一映射
    // 查询所有订单，并查询出订单所属用户
    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        IOrderMapper mapper = sqlSession.getMapper(IOrderMapper.class);
        List<Order> orderByUser = mapper.findOrderByUser();
        for (Order order:orderByUser){
            System.out.println(order.toString());
        }
    }

    // 一对多查询 ， 查询出用户的所有订单
    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
        List<User> userByOrder = mapper.findUserByOrder();
        for (User user:userByOrder){
            System.out.println(user.toString());
        }
    }

    // 多对多查询，查询用户的角色列表
    @Test
    public void test3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
        List<User> userByRole = mapper.findUserByRole();
        for (User user:userByRole){
            System.out.println(user.toString());
        }
    }

}
