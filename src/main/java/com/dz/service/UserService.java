package com.dz.service;

import com.dz.mapper.*;
import com.dz.pojo.*;
import com.github.pagehelper.*;
import java.text.*;
import java.util.*;
import java.util.stream.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
@Slf4j
public class UserService {
  @Autowired private UserMapper userMapper;

  public Map getAllUserAndNum(int page, int size) {
    Map<String, Object> map = new HashMap<>();
    PageHelper.startPage(page, size);
    map.put("userList", userMapper.findAllUser());
    map.put("num", userMapper.CountNum());
    return map;
  }

  public List<User> getNoSignInList() {
    String nowDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

    List<User> ulist = userMapper.findAllUser();
   // 返回签到日期为空与签到日期与今天不同  即没签到的人的列表
    return ulist.stream()
        .filter(
            user ->
                 {
                  if (user.getSignInDate().isEmpty()) return true;
                  else if (!user.getSignInDate().substring(0, 10).equals(nowDate.substring(0, 10)))
                    return true;
                  else return false;
                })
        .collect(Collectors.toList());
  }
}
