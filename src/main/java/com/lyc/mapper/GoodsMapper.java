package com.lyc.mapper;


import com.lyc.pojo.*;
import io.swagger.annotations.*;
import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

@Repository
public interface GoodsMapper {
  @Select("select * from t_goods where goods_id = #{id} ")
  Goods findGoodsById(@Param("id") int id);
  @Delete("delete from t_goods where goods_id = #{id}")
  void deleteGoods(@Param("id") int id);
  @Insert("insert into t_goods values(#{goodsName},#{goodsPrice},#{goodsNum},#{supId},#{warnNum})")
  void insertGoods(@Param("goods")Goods goods);
  @Update("update t_goods set goodsName=#{goodsName},goodsPrice=#{goodsPrice},goodsNum=#{goodsNum},supId=#{supId},warnNum=#{warnNum}")
  void update(@Param("goods") Goods goods);
}
