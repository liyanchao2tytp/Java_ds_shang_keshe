package com.lyc.mapper;

import com.lyc.pojo.*;
import java.util.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.*;

@Repository
public interface SupplierMapper {
  @Select("select * from t_supplier")
  List<Supplier> findAllSupplier();

  @Select("select * from t_supplier where sup_id = #{id} ")
  Supplier findSupplierById(@Param("id") int id);

  @Insert("insert into t_supplier(sup_name, sup_contact, sup_phone, adress) values(#{sup.supName}, #{sup.supContact}, #{sup.supPhone}, #{sup.adress})")
  void addSupplier(@Param("sup") Supplier supplier);

  @Update("update t_supplier set sup_name=#{supName}, sup_contact=#{supContact}, sup_phone=#{supPhone}, adress=#{adress} where sup_id=#{id}")
  void alterSupplier(@Param("id") int id,@Param("supName")String name,@Param("supContact")String contact,@Param("supPhone") String phone,@Param("adress")String address);

}
