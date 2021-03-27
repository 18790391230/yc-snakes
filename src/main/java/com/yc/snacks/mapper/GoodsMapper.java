package com.yc.snacks.mapper;

import com.yc.snacks.domain.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * GoodsMapper继承基类
 */
public interface GoodsMapper extends MyBatisBaseDao<Goods, Integer> {

    List<Goods> selectByIdList(@Param("goodsIdList") List<Integer> goodsList);
}