package com.ilongli.shardingspheredemo;

import com.ilongli.shardingspheredemo.entity.User;
import com.ilongli.shardingspheredemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class ShardingSphereDemoApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        for (int i = 0; i < 20; i++) {
            //这里ID自动生成1-10，然后插入数据库
            userMapper.addUser(new User(i, "abc", 18));
        }
    }

    @Test
    void testGet() {
        User user = userMapper.getUserById(3);
        System.out.println(user);
    }

    @Test
    void testBetween() {
        List<User> users = userMapper.listUserBetweenId(3, 5);
        /*
        分表时：
        select * from user_0 where id between ? and ? UNION ALL select * from user_1 where id between ? and ? ::: [3, 5, 3, 5]
         */
        System.out.println(users);
    }

    @Test
    void testReadWrite() {
        userMapper.addUser(new User(12, "bbb", 28));
        System.out.println(userMapper.getUserById(12));
    }

}