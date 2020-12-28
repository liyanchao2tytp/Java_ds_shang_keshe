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
}
