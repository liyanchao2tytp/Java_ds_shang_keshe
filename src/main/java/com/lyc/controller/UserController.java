package com.lyc.controller;

import com.auth0.jwt.interfaces.*;
import com.lyc.mapper.*;
import com.lyc.pojo.*;
import com.lyc.service.*;
import com.lyc.util.*;
import io.swagger.annotations.*;
import io.swagger.models.auth.*;
import java.util.*;
import javax.servlet.http.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class UserController {
  @Autowired private UserService userService;

  @Autowired private SupplierMapper supplierMapper;
  @ApiOperation("获取用户详细信息")
  @PostMapping("/usr")
  public Map<String, Object> getUsrDetail(HttpServletRequest request) {
    Map<String, Object> map = new HashMap<>();
    String token = request.getHeader("token");
    DecodedJWT verify = JWTUtil.verify(token);
    log.info("用户id：[{}]", verify.getClaim("id").asString());

    map.put(
        "usrdetail", userService.getUserDetail(Integer.parseInt(verify.getClaim("id").asString())));
    return map;
  }



}


