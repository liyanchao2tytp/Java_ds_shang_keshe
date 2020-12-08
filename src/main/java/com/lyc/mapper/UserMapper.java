package com.lyc.mapper;

import com.lyc.pojo.*;
import java.util.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Repository
public interface UserMapper {
  @Select("select * from t_user")
  @Results(id = "userMap",value = {
      @Result(column = "id",property = "id"),
      @Result(column = "username",property = "userName"),
      @Result(column = "password",property = "passWord"),
      @Result(column = "career",property = "career"),
  })
  List<User> findAllUser();

  @Select("select * from t_user where id = #{id}")
  @ResultMap("userMap")
  User findUser(@Param("id") int id);

  @Select("select * from t_user where username = #{userName} and password = #{passWord}")
  @ResultMap("userMap")
  User checkLogin(@Param("userName") String userName, @Param("passWord") String passWord);

  @Delete("delete from t_user where id = #{id}")
  @ResultMap("userMap")
  void deleteUser(@Param("id") int id);

  @Update("update t_user set username=#{username}, password=#{password}, career=#{career} where id = #{id}")
  @ResultMap("userMap")
  void alterUser(@Param("username") String usrName,@Param("password")String psWord,@Param("career")int career,@Param("id") int id);

  @Insert("insert into t_user(username, password, career) values(#{name}, #{word}, #{career})")
  @ResultMap("userMap")
  void add(@Param("name")String name,@Param("word")String word,@Param("career")Integer career);
}
