package com.lyc.service;

import com.github.pagehelper.*;
import com.lyc.mapper.*;
import com.lyc.pojo.*;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

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
