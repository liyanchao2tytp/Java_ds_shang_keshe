package com.lyc.pojo;

import io.swagger.annotations.*;
import lombok.*;

@ApiModel("雇员 员工")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
  @ApiModelProperty("主键")
  private Integer empId;
  @ApiModelProperty("员工姓名")
  private String empName;
  @ApiModelProperty("员工职位")
  private String empPost;
  @ApiModelProperty("手机号")
  private String empPhone;
}
