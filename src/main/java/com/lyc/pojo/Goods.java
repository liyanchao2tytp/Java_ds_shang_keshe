package com.lyc.pojo;

import io.swagger.annotations.*;
import lombok.*;

//@Api(注释)
@ApiModel("货物实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Goods {
  @ApiModelProperty("主键")
    private String goodsId;
  @ApiModelProperty("货物名")
    private String goodsName;
  @ApiModelProperty("价格")
    private String goodsPrice;
  @ApiModelProperty("数量")
    private String goodsNum;
  @ApiModelProperty("供应商外键")
    private Integer supId;
  @ApiModelProperty("警告数量")
    private Integer warnNum;
}
