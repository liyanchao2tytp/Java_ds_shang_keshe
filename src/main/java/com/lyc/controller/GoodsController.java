package com.lyc.controller;

import com.lyc.mapper.*;
import com.lyc.pojo.*;
import io.swagger.annotations.*;
import java.util.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class GoodsController {
  @Autowired private GoodsMapper goodsMapper;

  @ApiOperation("查询所有商品")
  @GetMapping("/goods/list")
  public List<Goods> findAllGoods() {
    return goodsMapper.findAllGoods();
  }

  @ApiOperation("根据id查询商品")
  @GetMapping("/goods/{id}")
  public Goods findAllGoods(@PathVariable("id") int id) {
        log.info("[{}}]",goodsMapper.findGoodsById(id));
//    System.out.println(id);
//    System.out.println(goodsMapper.findGoodsById(id));
        return goodsMapper.findGoodsById(id);
  }

  @ApiOperation("添加一个商品")
  @PostMapping("/goods")
  public void addGoods(@RequestBody LinkedHashMap<String, String> goods) {
    Goods gds = new Goods();
    gds.setGoodsName(goods.get("goods_name"));
    gds.setGoodsNum(Integer.parseInt(goods.get("goods_num")));
    gds.setGoodsPrice(Float.parseFloat(goods.get("goods_price")));
    gds.setSupId(Integer.parseInt(goods.get("goods_supplier")));
    gds.setWarnNum(Integer.parseInt(goods.get("calarm_num")));
    goodsMapper.insertGoods(gds);
  }

  @ApiOperation("删除商品")
  @DeleteMapping("/goods")
  public void deleteGoods(@RequestParam("id") int id) {
    goodsMapper.deleteGoods(id);
  }

  @ApiOperation("修改商品")
  @PutMapping("/goods")
  public void alterGoods(@RequestBody LinkedHashMap<String, String> goods) {
    Goods gds = new Goods();
    gds.setGoodsId(Integer.parseInt(goods.get("id")));
    gds.setGoodsName(goods.get("goods_name"));
    gds.setGoodsNum(Integer.parseInt(goods.get("goods_num")));
    gds.setGoodsPrice(Float.parseFloat(goods.get("goods_price")));
    //    Integer.valueOf(goods.get("goods_supplier"))
    gds.setSupId(1);
    gds.setWarnNum(Integer.parseInt(goods.get("calarm_num")));
    goodsMapper.updateGoods(gds);
  }

  @ApiOperation("修改is_delete的值为true")
  @PutMapping("/recycle")
  public void recycleGoods(@RequestBody LinkedHashMap<String,Integer>body) {
    log.info("{[]}",body);
    try{
      goodsMapper.toRecycle(body.get("id"),body.get("yn_goto_recycle"));
    }catch (Exception e){
      e.printStackTrace();
    }
  }
}
