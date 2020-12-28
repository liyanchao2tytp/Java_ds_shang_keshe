package com.dz.mapper;

import com.dz.pojo.*;
import java.util.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.*;

@Repository
public interface OrderMapper {
  @Select("SELECT * FROM t_order")
  List<Order> findAll();

  @Select("SELECT * FROM t_order WHERE sale_id = #{id} ")
  Order findById(@Param("id") int id);

  @Insert("INSERT INTO t_order(goods_name, sale_date, sale_price, buy_num, emp_name) VALUES(#{order.goodsName}, #{order.saleDate}, #{order.salePrice}, #{order.buyNum}, #{order.empName})")
  void add(@Param("order") Order order);

  @Delete("DELETE FROM t_order WHERE sale_id=#{id}")
  void delete(@Param("id")int id);


}
