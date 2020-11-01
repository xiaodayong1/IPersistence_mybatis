package com.xiao;

import com.xiao.dao.IUserDao;
import com.xiao.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.List;

/**
 * @ClassName : test  //类名
 * @Description : 测试  //描述
 * @Author : Xiaodayong  //作者
 * @Date: 2020-10-30 16:07  //时间
 */
public class test {

    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactoryBuild = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactoryBuild.openSession();

//        // 新增
//        User user = new User();
//        user.setUsername("憨憨");
//        sqlSession.insert("user.add",user);
//        sqlSession.commit();

        //修改
        User user2 = new User();
        user2.setId(1);
        user2.setUsername("肖大勇1");
        int update = sqlSession.update("user.update", user2);
        if(update>0){
            sqlSession.commit();
        }

        //删除
        sqlSession.delete("user.delete",5);
        sqlSession.commit();

        // 查询
        List<User> userList = sqlSession.selectList("user.findAll");
        for (User user1:userList){
            System.out.println(user1.toString());
        }
        sqlSession.close();


    }

    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        List<User> userList = mapper.findAll();
        for (User user:userList){
            System.out.println(user.toString());
        }
    }

    // 多条件查询 测试if 标签
    @Test
    public void test3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);

        User user = new User();
        user.setId(2);
        user.setUsername("zhangsan");
        Object byCondition =(User) mapper.findByCondition(user);
        System.out.println(byCondition.toString());
    }


    // 多条件查询 测试if 标签
    @Test
    public void test4() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);

        int[] arr = {1,2};
        List<User> byIds = mapper.findByIds(arr);

        for (User user:byIds){
            System.out.println(user.toString());
        }
    }
}
