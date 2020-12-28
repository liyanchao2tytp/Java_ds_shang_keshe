package com.lyc.controller;

import com.lyc.mapper.*;
import com.lyc.pojo.*;
import io.swagger.annotations.*;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
@RestController
public class SupplierController {
  @Autowired private SupplierMapper supplierMapper;

  @ApiOperation("查询所有供应商")
  @GetMapping("/supplier/list")
  public List<Supplier> getAllEmp() {
    return supplierMapper.findAllSupplier();
  }

  @ApiOperation("根据id查询供应商")
  @GetMapping("/supplier/{id}")
  public Supplier get(@PathVariable("id") int id) {
    return supplierMapper.findSupplierById(id);
  }
  @ApiOperation("添加供应商")
  @PostMapping("/supplier")
  public void  add(@RequestBody LinkedHashMap<String,String> body){

    Supplier supplier = new Supplier();
    supplier.setSupName(body.get("supplier"));
    supplier.setAdress(body.get("address"));
    supplier.setSupContact(body.get("contact"));
    supplier.setSupPhone(body.get("phone"));

    supplierMapper.addSupplier(supplier);
  }

  @ApiOperation("更改供应商信息")
  @PutMapping("/supplier")
  public void alter(@RequestBody LinkedHashMap<String,String> body){
    supplierMapper.alterSupplier(Integer.parseInt(body.get("id")),body.get("supplier"),body.get("contact"),body.get("phone"),body.get("address"));
  }
  @ApiOperation("删除供应商")
  @DeleteMapping("/supplier")
  public void delete(@RequestBody LinkedHashMap<String,Integer> body){
    supplierMapper.deleteSupplier(body.get("id"));
  }

}
