package com.cyt.test;

import com.cyt.dao.IUserDao;
import com.cyt.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before//用于在测试方法之前执行
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        sqlSession = factory.openSession(true);//此处的true是设置自动提交
        userDao = sqlSession.getMapper(IUserDao.class);
    }
    @After//用于在测试方法之后执行
    public void desTroy() throws Exception{
//        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
    @Test
    public void testFindAll() throws Exception{
        List<User> users = userDao.findAll();
        for (User u : users) {
            System.out.println(u);
        }
    }
}
