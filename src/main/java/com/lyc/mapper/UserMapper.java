package com.lyc.mapper;

import com.lyc.pojo.*;
import java.util.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.*;

@Repository
public interface UserMapper {
  @Select("select * from t_user")
  @Results(id = "userMap",value = {
      @Result(column = "id",property = "id"),
      @Result(column = "username",property = "userName"),
      @Result(column = "password",property = "passWord"),
      @Result(column = "career",property = "career"),
      @Result(column = "careerId",property = "careerId")
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

  @Update("update t_user set username=#{username}, password=#{password}, career=#{career}, careerId=#{careerId}")
  @ResultMap("userMap")
  void alterUser(@Param("username") String usrName,@Param("password")String psWord,@Param("career")int career,@Param("careerId")int careerId);
}
