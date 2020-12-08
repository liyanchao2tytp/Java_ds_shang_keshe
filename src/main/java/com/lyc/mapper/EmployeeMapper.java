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
  Employee findEmpById(@Param("id") int id);

  @Select("select count(*) from t_employee")
  Integer CountNum();

  @Insert(
      "insert into t_employee(emp_name, emp_post, emp_phone) values(#{emp.empName}, #{emp.empPost}, #{emp.empPhone})")
  void addEmp(@Param("emp") Employee emp);
  @Update("update t_employee set emp_name=#{empName}, emp_post=#{empPost}, emp_phone=#{empPhone} where emp_id=#{empId}")
  void alterEmp(@Param("empId") int empId,@Param("empName")String empName,@Param("empPost")String empPost,@Param("empPhone")String empPhone);

  @Delete("delete from t_employee where emp_id = #{id}")
  void deleteEmp(@Param("id") int id);
}
