package com.lyc.mapper;

import com.lyc.pojo.*;
import java.util.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.mapping.*;
import org.springframework.stereotype.*;

@Repository
public interface GoodsMapper {

  @Select("select * from t_goods where is_delete = 0")
  @Results(
      id = "goodsMap",
      value = {
        @Result(id = true, column = "goods_id", property = "goodsId"),
        @Result(column = "goods_name", property = "goodsName"),
        @Result(column = "goods_price", property = "goodsPrice"),
        @Result(column = "goods_num", property = "goodsNum"),
        @Result(column = "sup_id", property = "supId"),
        @Result(
            property = "supplier",
            column = "sup_id",
            one =
                @One(
                    select = "com.lyc.mapper.SupplierMapper.findSupplierById",
                    fetchType = FetchType.EAGER)),
        @Result(column = "warn_num", property = "warnNum"),
        @Result(column = "is_delete",property = "isDelete")
      })
  List<Goods> findAllGoods();

  @Select("SELECT * FROM t_goods where goods_id = #{id} and is_delete = 0")
  @ResultMap("goodsMap")
  Goods findGoodsById(@Param("id") int id);

  @Select({"SELECT * FROM t_goods WHERE goods_name like concat('%',#{name},'%')"})
  @ResultMap("goodsMap")
  List<Goods> fuzzySearch (@Param("name")String name);

  @Select("SELECT * FROM t_goods WHERE is_delete = 1")
  @ResultMap("goodsMap")
  List<Goods> selectRecycle();

  @Delete("delete FROM t_goods WHERE goods_id = #{id}")
  @ResultMap("goodsMap")
  void deleteGoods(@Param("id") int id);

  @Insert(
      "INSERT INTO t_goods(goods_name, goods_price, goods_num, sup_id, warn_num)"
          + " VALUES(#{goods.goodsName},#{goods.goodsPrice},#{goods.goodsNum},#{goods.supId},#{goods.warnNum})")
  @ResultMap("goodsMap")
  int insertGoods(@Param("goods") Goods goods);

  @Update(
      "update t_goods set goods_name=#{goods.goodsName},goods_price=#{goods.goodsPrice},goods_num=#{goods.goodsNum},sup_id=#{goods.supId},warn_num=#{goods.warnNum} where goods_id=#{goods.goodsId}")
  @ResultMap("goodsMap")
  void updateGoods(@Param("goods") Goods goods);

  @Update("update t_goods set is_delete = #{ynRecycle} where goods_id = #{id}")
  @ResultMap("goodsMap")
  void toRecycle(@Param("id")int id,@Param("ynRecycle")int ynRecycle);




}
