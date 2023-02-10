package com.ilongli.shardingspheredemo.mapper;

import com.ilongli.shardingspheredemo.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User getUserById(int id);

    @Select("select * from user where id between #{from} and #{to}")
    List<User> listUserBetweenId(Integer from, Integer to);

    @Insert("insert into user(id, name, age) values(#{id}, #{name}, #{age})")
//    @Insert("insert into user(name, age) values(#{name}, #{age})")
    int addUser(User user);

    @Delete("delete from user where id = #{id}")
    int deleteById(int id);
}