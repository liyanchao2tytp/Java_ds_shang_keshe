package com.dz.mapper;

import com.dz.pojo.*;
import java.util.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.*;

@Repository
public interface SupplierMapper {
  @Select("SELECT * FROM t_supplier")
  List<Supplier> findAllSupplier();

  @Select("SELECT * FROM t_supplier WHERE sup_id = #{id} ")
  Supplier findSupplierById(@Param("id") int id);

  @Insert("INSERT INTO t_supplier(sup_name, sup_contact, sup_phone, adress) VALUES(#{sup.supName}, #{sup.supContact}, #{sup.supPhone}, #{sup.adress})")
  void addSupplier(@Param("sup") Supplier supplier);

  @Update("UPDATE t_supplier SET sup_name=#{supName}, sup_contact=#{supContact}, sup_phone=#{supPhone}, adress=#{adress} WHERE sup_id=#{id}")
  void alterSupplier(@Param("id") int id,@Param("supName")String name,@Param("supContact")String contact,@Param("supPhone") String phone,@Param("adress")String address);

  @Delete("DELETE FROM t_supplier WHERE sup_id=#{id}")
  void deleteSupplier(@Param("id")int id);

}
