package com.lyc.controller;

import com.lyc.mapper.*;
import com.lyc.pojo.*;
import io.swagger.annotations.*;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class GoodsController {
  @Autowired private GoodsMapper goodsMapper;

  @ApiOperation("查询所有商品")
  @GetMapping("/goods/list")
  public List<Goods> findAllGoods() {
    return goodsMapper.findAllGoods();
  }

  @ApiOperation("添加一个商品")
  @PutMapping("/goods")
  public void addGoods(@RequestBody LinkedHashMap<String, String> goods) {
    System.out.println(goods);
    Goods gds = new Goods();
    gds.setGoodsName(goods.get("goods_name"));
    gds.setGoodsNum(Integer.parseInt(goods.get("goods_num")));
    gds.setGoodsPrice(Float.parseFloat(goods.get("goods_price")));
    //    Integer.valueOf(goods.get("goods_supplier"))
    gds.setSupId(1);
    gds.setWarnNum(Integer.parseInt(goods.get("calarm_num")));
    goodsMapper.insertGoods(gds);
  }
}
