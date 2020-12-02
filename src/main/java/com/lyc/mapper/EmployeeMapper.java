package com.lyc.mapper;

import com.lyc.pojo.*;
import java.util.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.*;

@Repository
public interface EmployeeMapper {
  @Select("select * from t_employee")
  List<Employee> findAllEmp();
  @Select("select * from t_employee where emp_id = #{id}")
  Employee findEmpById(@Param("id")int id);

}
