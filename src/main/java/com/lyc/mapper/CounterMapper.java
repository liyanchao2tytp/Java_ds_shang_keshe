package com.lyc.mapper;

import com.lyc.pojo.*;
import java.util.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.*;

@Repository
public interface CounterMapper {
  @Select("select * from t_counter ")
  List<Counter> findAllCounter();
  @Select("select * from t_counter where emp_id=#{id}")
  Counter findCounterById(@Param("id")Integer id);
  @Delete("delete from t_counter where emp_id = #{id}")
  void deleteCounter(@Param("id") int id);

  @Insert("insert into t_counter values(#{salePrice},#{counterNum},#{calarmNum})")
  void insertCounter(@Param("counter") Counter counter);

  @Update(
      "updateGoods t_counter set sale_price=#{salePrice},counter_num=#{counterNum},calarm_num=#{calarmNum}")
  void update(@Param("counter") Counter counter);


}
