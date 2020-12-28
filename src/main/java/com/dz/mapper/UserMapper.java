package com.lyc.mapper;

import com.lyc.pojo.*;
import java.util.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.*;

@Repository
public interface UserMapper {
  @Select("SELECT * FROM t_user")
  @Results(id = "userMap",value = {
      @Result(column = "id",property = "id"),
      @Result(column = "username",property = "userName"),
      @Result(column = "password",property = "passWord"),
      @Result(column = "career",property = "career"),
  })
  List<User> findAllUser();

  @Select("SELECT * from t_user WHERE id = #{id}")
  @ResultMap("userMap")
  User findUser(@Param("id") int id);

  @Select("SELECT * FROM t_user WHERE username = #{userName} AND password = #{passWord}")
  @ResultMap("userMap")
  User checkLogin(@Param("userName") String userName, @Param("passWord") String passWord);

  @Delete("DELETE FROM t_user WHERE id = #{id}")
  @ResultMap("userMap")
  void deleteUser(@Param("id") int id);

  @Update("UPDATE t_user SET username=#{username}, password=#{password}, career=#{career} WHERE id = #{id}")
  @ResultMap("userMap")
  void alterUser(@Param("username") String usrName,@Param("password")String psWord,@Param("career")int career,@Param("id") int id);

  @Insert("INSERT INTO t_user(username, password, career) VALUES(#{name}, #{word}, #{career})")
  @ResultMap("userMap")
  void add(@Param("name")String name,@Param("word")String word,@Param("career")Integer career);
}
