package com.lyc.controller;

import com.lyc.mapper.*;
import com.lyc.pojo.*;
import io.swagger.annotations.*;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.transaction.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
  @Autowired
  OrderMapper orderMapper;

  @ApiOperation("查询所有订单")
  @GetMapping("/order/list")
  public List<Order> getAll(){
    return orderMapper.findAll();
  }

  @ApiOperation("根据id查询订单")
  @GetMapping("/order/{id}")
  public Order get(@PathVariable("id") int id){
    return orderMapper.findById(id);
  }
  @ApiOperation("添加用户")
  @PostMapping("/order")
  public void add(@RequestBody LinkedHashMap<String,String> body){
    Order order = new Order();
    order.setBuyNum(Integer.parseInt(body.get("num")));
    orderMapper.add(order);
  }

  @ApiOperation("删除订单")
  @DeleteMapping("/order")
  @Transactional
  public void delete(@RequestBody LinkedHashMap<String,Integer> body){
    orderMapper.delete(body.get("id"));
  }




}
