package com.lyc.mapper;

import com.lyc.pojo.*;
import java.util.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.*;

@Repository
public interface GoodsMapper {
  @Select("select * from t_goods")
  @Results(
      id = "goodsMap",
      value = {
        @Result(id = true, column = "goods_id", property = "goodsId"),
        @Result(column = "goods_name", property = "goodsName"),
        @Result(column = "goods_price", property = "goodsPrice"),
        @Result(column = "goods_num", property = "goodsNum"),
        @Result(column = "sup_id", property = "supId"),
        @Result(column = "warn_num", property = "warnNum")
      })
  List<Goods> findAllGoods();

  @Select("select * from t_goods where goods_id = #{id} ")
  @ResultMap("goodsMap")
  Goods findGoodsById(@Param("id") int id);

  @Delete("delete from t_goods where goods_id = #{id}")
  @ResultMap("goodsMap")
  void deleteGoods(@Param("id") int id);

  @Insert(
      "insert into t_goods(goods_name, goods_price, goods_num, sup_id, warn_num)"
          + " values(#{goods.goodsName},#{goods.goodsPrice},#{goods.goodsNum},#{goods.supId},#{goods.warnNum})")
  @ResultMap("goodsMap")
  int insertGoods(@Param("goods") Goods goods);

  @Update(
      "update t_goods set goodsName=#{goods.goodsName},goodsPrice=#{goods.goodsPrice},goodsNum=#{goods.goodsNum},supId=#{goods.supId},warnNum=#{goods.warnNum}")
  @ResultMap("goodsMap")
  void update(@Param("goods") Goods goods);
}
