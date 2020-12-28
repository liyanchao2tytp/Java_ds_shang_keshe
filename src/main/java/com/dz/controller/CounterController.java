package com.lyc.controller;

import com.lyc.mapper.*;
import com.lyc.pojo.*;
import com.lyc.service.*;
import io.swagger.annotations.*;
import java.util.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController

public class CounterController {
  @Autowired private CounterMapper counterMapper;
  @Autowired private CounterService counterService;

  @ApiOperation("查询所有柜台商品")
  @GetMapping("/counter")
  public List<Counter> getAllCounter(){
    return counterMapper.findAllCounter();
  }

  @ApiOperation("根据id查询柜台物品")
  @GetMapping("/counter/{id}")
  public Counter getCounter(@PathVariable("id")int id){
    return counterMapper.findCounterById(id);
  }

  @ApiOperation("库存转向柜台")
  @PutMapping("/storeToCounter")
  public String storeToCounter(@RequestBody LinkedHashMap<String,String> body){
     return counterService.goodsToCounter(body);
  }

  @ApiOperation("更改柜台商品信息")
  @PutMapping("/counter")
  public void alter(@RequestBody LinkedHashMap<String,String> body){
     counterMapper.update(Integer.parseInt(body.get("id")),body.get("name"),Float.parseFloat(body.get("price")),Integer.parseInt(body.get("num")),Integer.parseInt(body.get("alarm")));
  }

  @ApiOperation("新建柜台商品信息")
  @PostMapping("/counter")
  public void add(@RequestBody LinkedHashMap<String,String> body){
    counterMapper.insertCounter(body.get("name"),Float.parseFloat(body.get("price")),Integer.parseInt(body.get("num")),Integer.parseInt(body.get("alarm")));
  }
  @ApiOperation("删除指定柜台商品")
  @DeleteMapping("/counter")
  public void delete(@RequestBody LinkedHashMap<String,Integer> body){
    counterMapper.deleteCounter(body.get("id"));
  }

}
