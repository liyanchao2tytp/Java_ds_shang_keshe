package com.lyc.controller;

import com.lyc.mapper.*;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import com.lyc.pojo.Goods;
@RestController
public class HelloController {
    @Autowired
    private GoodsMapper goodsMapper;
    @ApiOperation("返回Hello")
    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }
    @ApiOperation("根据id获取货物")
    @PostMapping("/user")
    public Goods getGoods(@ApiParam("货物id")String id){
        System.out.println(goodsMapper.findGoodsById(1));
        return goodsMapper.findGoodsById(1);
    }
}
