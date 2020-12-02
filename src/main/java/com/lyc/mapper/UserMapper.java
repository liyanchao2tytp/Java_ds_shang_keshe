package com.lyc.mapper;

import com.lyc.pojo.*;
import java.util.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.*;

@Repository
public interface UserMapper {
  @Select("select * from t_user")
  List<User> findAllUser();

  @Select("select * from t_user where id = #{id}")
  User findUser(@Param("id") int id);

  @Select("select * from t_user where username = #{userName} and password = #{passWord}")
  User checkLogin(@Param("userName") String userName, @Param("passWord") String passWord);

  @Delete("delete from t_user where id = #{id}")
  void deleteUser(@Param("id") int id);
}
