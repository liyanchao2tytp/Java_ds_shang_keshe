package com.lyc.mapper;

import com.lyc.pojo.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.*;

@Repository
public interface SupplierMapper {
  @Select("select * from t_supplier where sup_id = #{id} ")
  Supplier findSupplierById(@Param("id") int id);

}
