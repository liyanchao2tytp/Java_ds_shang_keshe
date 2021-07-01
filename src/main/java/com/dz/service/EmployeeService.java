package com.dz.service;

import com.github.pagehelper.*;
import com.dz.mapper.*;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class EmployeeService {
  @Autowired  private EmployeeMapper employeeMapper;
  public Map getAllEmpAndNum(int page,int size) {
    Map<String, Object> map = new HashMap<>();
    PageHelper.startPage(page, size);
    map.put("empList", employeeMapper.findAllEmp());
    map.put("num", employeeMapper.CountNum());
    return map;
  }
}
