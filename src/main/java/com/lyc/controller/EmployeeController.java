package com.lyc.controller;

import com.github.pagehelper.*;
import com.lyc.mapper.*;
import com.lyc.pojo.*;
import com.lyc.service.*;
import io.swagger.annotations.*;
import java.util.*;
import lombok.extern.slf4j.*;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
@RestController
@Slf4j
public class EmployeeController {
  @Autowired private EmployeeMapper employeeMapper;
  @Autowired private EmployeeService employeeService;

  @ApiOperation("查询所有雇员")
  @GetMapping("/emp/list")
  public Map getUser(@RequestParam(value = "page",defaultValue = "1")int page,@RequestParam(value = "size",defaultValue = "10")int size){
    return employeeService.getAllEmpAndNum(page,size);
  }
//    public Map getUser(@RequestParam( "page")int page,@RequestParam( "size")int size){
//    log.info("[{}] [{}]",page,size);
//    return employeeService.getAllEmpAndNum(page,size);
//  }



  @ApiOperation("增加一个新雇员")
  @PostMapping("/emp")
  public void addEmp(@RequestBody LinkedHashMap<String, String> emps){
    log.info(emps.get("username"));
    Employee employee = new Employee();
    employee.setEmpName(emps.get("username"));
    employee.setEmpPhone(emps.get("phone"));
    employee.setEmpPost(emps.get("post"));
    employeeMapper.addEmp(employee);
  }

  @ApiOperation("根据id查询雇员")
  @GetMapping("/emp/{id}")
  public Employee getEmpById(@PathVariable("id")int id){
    return employeeMapper.findEmpById(id);
  }

  @ApiOperation("修改指定雇员")
  @PutMapping("/emp")
  public void alterEmp(@RequestBody LinkedHashMap<String,String> body){
    employeeMapper.alterEmp(Integer.parseInt(body.get("id")),body.get("username"),body.get("post"),body.get("phone"));
  }
  @ApiOperation("删除指定雇员")
  @DeleteMapping("/emp")
  public void  deleteEmp(@RequestBody LinkedHashMap<String,Integer> body){
    employeeMapper.deleteEmp(body.get("id"));
  }
}
