package com.lyc.pojo;

import io.swagger.annotations.*;
import lombok.*;

@ApiModel("订单")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
  private Integer saleId;
  private String goodsName;
  private String saleDate;
  private String salePrice;
  private Integer buyNum;
  private String empName;
}
