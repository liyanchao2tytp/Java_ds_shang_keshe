package com.lyc.controller;

import com.lyc.mapper.*;
import com.lyc.pojo.*;
import com.lyc.util.*;
import io.swagger.annotations.*;
import java.util.*;
import javax.servlet.http.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
  @Autowired private UserMapper userMapper;
  @Autowired private GoodsMapper goodsMapper;

  @ApiOperation("查询token中的个人信息")
  @GetMapping("/user")
  public Map getTokenContent(HttpServletRequest res) {
    HashMap<String, String> map = new HashMap<>();
    int id = Integer.parseInt(JWTUtil.verify(res.getHeader("token")).getClaim("id").asString());
    User user = userMapper.findUser(id);
    map.put("name", user.getUserName());
    map.put("career", user.getCareer().toString());
    return map;
  }
  @ApiOperation("查询登录权限")
  @GetMapping("/login")
  public Integer checkPower(HttpServletRequest request){
    return Integer.parseInt(JWTUtil.verify(request.getHeader("token")).getClaim("career").asString());
  }
  @ApiOperation("登录")
  @PostMapping("/login")
  public Map<String,Object> checkLogin(@RequestBody LinkedHashMap<String, String> body) {
    Map<String,Object> map = new HashMap<>();
    try{
      User user = userMapper.checkLogin(body.get("userName"), body.get("passWord"));
      Map<String, String> payload = new HashMap<>();
      payload.put("id", String.valueOf(user.getId()));
      payload.put("career",String.valueOf(user.getCareer()));
      String token = JWTUtil.getToken(payload);
      map.put("state", true);
      map.put("msg", "success");
      map.put("token", token);  //响应token
    }catch (Exception e){
      map.put("state",false);
      map.put("msg", e.getMessage());
    }
    return map;
  }

  @ApiOperation("登陆后跳转页面查询用户信息")
  @GetMapping("/select")
  public Object getUsrDetail(){
    return"";
  }
}
