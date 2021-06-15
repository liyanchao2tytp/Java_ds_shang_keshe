package com.dz.pojo;

import io.swagger.annotations.*;
import lombok.*;

@ApiModel("用户实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
  @ApiModelProperty("主键")
  private Integer id;
  @ApiModelProperty("用户名")
  private String userName;
  @ApiModelProperty("密码")
  private String passWord;
  @ApiModelProperty("权限")
  private Integer career;
  @ApiModelProperty("职位")
  private String post;
  @ApiModelProperty("打卡次数")
  private Integer num;
  @ApiModelProperty("打卡时间")
  private String signInDate;
}
