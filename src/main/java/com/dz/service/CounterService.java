package com.dz.service;

import com.dz.mapper.*;
import com.dz.pojo.*;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
public class CounterService {
  @Autowired private CounterMapper counterMapper;
  @Autowired private GoodsMapper goodsMapper;
  @Transactional
  public String goodsToCounter(LinkedHashMap<String,String> body){
    //  查库存中某货物
    Goods goods = goodsMapper.findGoodsById(Integer.parseInt(body.get("id")));
    // 查柜寸中是否有该物品
    Counter counter = counterMapper.findCounterByName(goods.getGoodsName());
    if (goods.getGoodsNum()<Integer.parseInt(body.get("num"))){
      return "上架数量超过库存数量";
    }
    if (counter!=null){       // 有该物品 修改数量
      //  库存减少
      goods.setGoodsNum(goods.getGoodsNum()-Integer.parseInt(body.get("num")));
      //  柜存增多
      counter.setCounterNum(Integer.parseInt(body.get("num")));
      //  更新库存
      goodsMapper.updateGoods(goods);
      //  更新柜存
      counterMapper.update(
          counter.getMerchId(),
          counter.getCounterName(),
          counter.getSalePrice(),
          counter.getCounterNum(),
          Integer.parseInt(body.get("alarm")));
    }else {                 //  柜寸中没有 新增一条数据
      //  库存减少
      goods.setGoodsNum(goods.getGoodsNum()-Integer.parseInt(body.get("num")));
      //  插入柜存
      counterMapper.insertCounter(goods.getGoodsName(),Float.parseFloat(body.get("price")),Integer.parseInt(body.get("num")),Integer.parseInt(body.get("alarm")));
      //  更新库存
      goodsMapper.updateGoods(goods);
    }
    return "success";
  }

}
