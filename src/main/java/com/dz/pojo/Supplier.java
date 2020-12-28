package com.dz.pojo;

import io.swagger.annotations.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel("供应商")
public class Supplier {
  @ApiModelProperty("主键")
  private Integer supId;
  @ApiModelProperty("供应商名称")
  private String supName;
  @ApiModelProperty("联系人姓名")
  private String supContact;
  @ApiModelProperty("供应商电话")
  private String supPhone;
  @ApiModelProperty("供应商地址")
  private String adress;
}
