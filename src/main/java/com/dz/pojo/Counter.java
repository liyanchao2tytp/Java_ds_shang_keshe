package com.dz.pojo;

import io.swagger.annotations.*;
import lombok.*;

@ApiModel("柜存")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Counter {
  @ApiModelProperty("主键")
  private Integer merchId;
  @ApiModelProperty("货物名称")
  private String counterName;
  @ApiModelProperty("销售价格")
  private Float salePrice;
  @ApiModelProperty("柜台数量")
  private Integer counterNum ;
  @ApiModelProperty("警告数量")
  private Integer calarmNum;

}
