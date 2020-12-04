package com.lyc.service;

import com.lyc.mapper.*;
import com.lyc.pojo.*;
import java.lang.ProcessHandle.*;
import java.util.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
@Slf4j
public class UserService {
  @Autowired private UserMapper userMapper;
  @Autowired private SupplierMapper supplierMapper;
  @Autowired private EmployeeMapper employeeMapper;

  public Object getUserDetail(int id) {
    User user = userMapper.findUser(id);
    log.info("[{}]", user.getCareerId());
//    1：雇员  2：供应商 3：管理员
    if (user.getCareer() == 1) {
      log.info("userService获取用户详细 雇员 [{}]",employeeMapper.findEmpById(user.getCareerId()));
      return employeeMapper.findEmpById(user.getCareerId());
    }else if(user.getCareer() == 2){
      log.info("userService获取用户详细 供应商 [{}]",supplierMapper.findSupplierById(user.getCareerId()));
      return supplierMapper.findSupplierById(user.getCareerId());
    }
    return user;
  }

  public List<User> getAll(){
    List<User> users = userMapper.findAllUser();
    List<User> all = new ArrayList<>();
    for (User u :users ) {
      //    1：雇员  2：供应商 3：管理员
      if (u.getCareer()==1) {
        u.setObj(employeeMapper.findEmpById(u.getCareerId()));

      }else if(u.getCareer()==2){
        u.setObj(supplierMapper.findSupplierById(u.getCareerId()));
      }
      all.add(u);
    }
    return all;
  }
}
