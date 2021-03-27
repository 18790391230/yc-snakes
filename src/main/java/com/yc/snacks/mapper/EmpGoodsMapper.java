package com.yc.snacks.mapper;

import com.yc.snacks.domain.EmpGoods;
import org.apache.ibatis.annotations.Param;

/**
 * EmpGoodsMapper继承基类
 */
public interface EmpGoodsMapper extends MyBatisBaseDao<EmpGoods, Integer> {

    EmpGoods selectByGoodsId(@Param("empId") Integer empId, @Param("goodsId") Integer goodsId);

    void updateByGoodsId(@Param("empId") Integer empId, @Param("goodsId") Integer goodsId);

    void deleteByGoodsId(@Param("empId") Integer empId, @Param("goodsId") Integer goodsId);
}