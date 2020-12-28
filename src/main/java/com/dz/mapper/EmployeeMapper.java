package com.lyc.mapper;

import com.lyc.pojo.*;
import java.util.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.*;

@Repository
public interface EmployeeMapper {
  @Select("SELECT * FROM t_employee")
  List<Employee> findAllEmp();

  @Select("SELECT * FROM t_employee WHERE emp_id = #{id}")
  Employee findEmpById(@Param("id") int id);

  @Select("SELECT count(*) FROM t_employee")
  Integer CountNum();

  @Insert(
      "INSERT INTO t_employee(emp_name, emp_post, emp_phone) VALUES(#{emp.empName}, #{emp.empPost}, #{emp.empPhone})")
  void addEmp(@Param("emp") Employee emp);
  @Update("UPDATE t_employee SET emp_name=#{empName}, emp_post=#{empPost}, emp_phone=#{empPhone} WHERE emp_id=#{empId}")
  void alterEmp(@Param("empId") int empId,@Param("empName")String empName,@Param("empPost")String empPost,@Param("empPhone")String empPhone);

  @Delete("DELETE FROM t_employee WHERE emp_id = #{id}")
  void deleteEmp(@Param("id") int id);
}
