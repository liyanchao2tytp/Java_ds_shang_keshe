package com.lyc.service;

import com.lyc.mapper.*;
import com.lyc.pojo.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class UserService {
  @Autowired private UserMapper userMapper;
  @Autowired private SupplierMapper supplierMapper;
  @Autowired private EmployeeMapper employeeMapper;

  public Object getUserDetail(int id) {
    User user = userMapper.findUser(id);
//    1：雇员  2：供应商 3：管理员
    if (user.getCareer() == 1) {
      return employeeMapper.findEmpById(user.getCareerId());
    }else if(user.getCareer() == 2){
      return supplierMapper.findSupplierById(user.getCareerId());
    }
    return user;
  }
}
