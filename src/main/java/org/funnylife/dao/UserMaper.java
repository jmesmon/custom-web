package org.funnylife.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.funnylife.vo.User;

import java.util.List;


@Mapper  
public interface UserMaper {  
      
    @Select("select * from t_user")
    List<User> Select(int age);

    @Select("<script> " +
            "SELECT * " +
            "FROM t_user " +
            " <where> " +
            " <if test=\"username != null\">username=#{username}</if> " +
            " <if test=\"password != null\"> AND password=#{password}</if> " +
            " </where> " +
            " </script> ")
    List<User> test(User user);
} 