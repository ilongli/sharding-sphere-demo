package com.ilongli.shardingspheredemo;

import com.ilongli.shardingspheredemo.entity.User;
import com.ilongli.shardingspheredemo.mapper.UserMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author ilongli
 * @date 2023/2/10 16:22
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("insert")
    public String insert(int id) {
        userMapper.addUser(new User(id, "testUser-"+id, 18));
        return "insert ok: " + id;
    }

    @GetMapping("get/{id}")
    public User getById(@PathVariable("id") int id) {
        return userMapper.getUserById(id);
    }

    @GetMapping("del/{id}")
    public String delById(@PathVariable("id") int id) {
        userMapper.deleteById(id);
        return "delete ok: " + id;
    }

}
