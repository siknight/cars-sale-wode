package com.car.test;

import com.car.CarsSaleApplication;
import com.car.dao.UserDao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = CarsSaleApplication.class)
@RunWith(SpringRunner.class)
public class TestDao {
    @Autowired
    UserDao dao;

    @Test
    public void testUserDao(){
        System.out.println(dao.LoginByUsername("aa"));
    }

    @Test
    public void testUserDao2(){
        dao.Register("xiang","xiang");
    }
    @Test
    public void testUserDao3(){
        dao.deleteById(28);
    }
    @Test
    public void testUserDao4(){
        dao.updateById("aaaaaaa","aaaaaaaaaa","男",27);
    }
}
