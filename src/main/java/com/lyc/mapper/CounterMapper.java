package com.lyc.mapper;

import com.lyc.pojo.*;
import java.util.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.*;

@Repository
public interface CounterMapper {
  @Select("select * from t_counter ")
  List<Counter> findAllCounter();
  @Select("select * from t_counter where merch_id=#{id}")
  Counter findCounterById(@Param("id")Integer id);
  @Select("select * from t_counter where counter_name = #{name}")
  Counter findCounterByName(@Param("name")String name);

  @Delete("delete from t_counter where merch_id = #{id}")
  void deleteCounter(@Param("id") int id);

  @Insert("insert into t_counter(counter_name, sale_price, counter_num, calarm_num) values(#{counterName},#{salePrice},#{counterNum},#{alarmNum})")
  void insertCounter(@Param("counterName") String name,@Param("salePrice")Float price,@Param("counterNum")int num,@Param("alarmNum")int alarm);

  @Update(
      "update t_counter set counter_name=#{counterName},sale_price=#{salePrice},counter_num=#{counterNum},calarm_num=#{calarmNum} where merch_id = #{id}")
  void update(@Param("id") int id,@Param("counterName")String name,@Param("salePrice") Float Price,@Param("counterNum")int num,@Param("calarmNum")int alarmNum );


}
