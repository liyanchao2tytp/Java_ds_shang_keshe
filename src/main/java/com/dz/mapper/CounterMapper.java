package com.dz.mapper;

import com.dz.pojo.*;
import java.util.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.*;

@Repository
public interface CounterMapper {
  @Select("SELECT * FROM t_counter ")
  List<Counter> findAllCounter();
  @Select("SELECT * FROM t_counter WHERE merch_id=#{id}")
  Counter findCounterById(@Param("id")Integer id);
  @Select("SELECT * FROM t_counter WHERE counter_name = #{name}")
  Counter findCounterByName(@Param("name")String name);

  @Delete("DELETE FROM t_counter WHERE merch_id = #{id}")
  void deleteCounter(@Param("id") int id);

  @Insert("INSERT INTO t_counter(counter_name, sale_price, counter_num, calarm_num) VALUES(#{counterName},#{salePrice},#{counterNum},#{alarmNum})")
  void insertCounter(@Param("counterName") String name,@Param("salePrice")Float price,@Param("counterNum")int num,@Param("alarmNum")int alarm);

  @Update(
      "UPDATE t_counter set counter_name=#{counterName},sale_price=#{salePrice},counter_num=#{counterNum},calarm_num=#{calarmNum} WHERE merch_id = #{id}")
  void update(@Param("id") int id,@Param("counterName")String name,@Param("salePrice") Float Price,@Param("counterNum")int num,@Param("calarmNum")int alarmNum );


}
