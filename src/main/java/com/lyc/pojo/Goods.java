package com.lyc.pojo;

import io.swagger.annotations.*;
import lombok.*;

// @Api(注释)
@ApiModel("货物实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Goods {
  @ApiModelProperty("主键")
  private Integer goodsId;

  @ApiModelProperty("货物名")
  private String goodsName;

  @ApiModelProperty("价格")
  private Float goodsPrice;

  @ApiModelProperty("数量")
  private Integer goodsNum;

  @ApiModelProperty("警告数量")
  private Integer warnNum;

  @ApiModelProperty("是否在回收站")
  private Integer isDelete;

  @ApiModelProperty("供应商外键")
  private Integer supId;
  private Supplier supplier;
}
