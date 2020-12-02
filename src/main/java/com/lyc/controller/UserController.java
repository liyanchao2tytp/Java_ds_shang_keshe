package com.lyc.controller;

import com.lyc.mapper.*;
import com.lyc.pojo.*;
import com.lyc.service.*;
import io.swagger.annotations.*;
import javax.servlet.http.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@ApiOperation("对用户进行操作")
@Slf4j
public class UserController {
  @Autowired private UserService userService;
  @PostMapping("/usr")
  public Object getUsrDetail(){

    return "";
//    return userService.getUserDetail((Integer) session.getAttribute("userId"));
  }


}
