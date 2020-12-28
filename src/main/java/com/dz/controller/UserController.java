package com.lyc.controller;

import com.lyc.mapper.*;
import com.lyc.pojo.*;
import com.lyc.service.*;
import io.swagger.annotations.*;
import java.util.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.transaction.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class UserController {
  @Autowired private UserMapper userMapper;
  @Autowired private UserService userService;

  @ApiOperation("获取用户详细信息")
  @GetMapping("/usr")
  public User getUsrDetail(@RequestParam("id")int id ) {
    return userMapper.findUser(id);
  }

  @ApiOperation("添加用户")
  @PostMapping("/usr")
  public void add(@RequestBody LinkedHashMap<String,String> body){
    userMapper.add(body.get("name"),body.get("word"),Integer.parseInt(body.get("power")));
  }
  @ApiOperation("修改用户")
  @PutMapping("/usr")
  public void update(@RequestBody LinkedHashMap<String ,String> body){
    userMapper.alterUser(body.get("name"),body.get("word"),Integer.parseInt(body.get("power")),Integer.parseInt(body.get("id")));
  }

  @ApiOperation("删除用户")
  @DeleteMapping("/usr")
  @Transactional
  public void delete(@RequestBody LinkedHashMap<String,Integer> body){
    userMapper.deleteUser(body.get("id"));
  }

  @ApiOperation("查询所有用户")
  @GetMapping("/usr/list")
  public List<User> get(){
    return userMapper.findAllUser();
  }



}


