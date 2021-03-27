package com.yc.snacks.mapper;

import com.yc.snacks.domain.GoodsType;

import java.util.List;

/**
 * GoodsTypeMapper继承基类
 */
public interface GoodsTypeMapper extends MyBatisBaseDao<GoodsType, Integer> {
    List<GoodsType> selectAll();
}