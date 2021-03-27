package com.yc.snacks.mapper;

import com.yc.snacks.domain.EmpGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * EmpGoodsMapper继承基类
 */
public interface EmpGoodsMapper extends MyBatisBaseDao<EmpGoods, Integer> {

    EmpGoods selectByGoodsId(@Param("empId") Integer empId, @Param("goodsId") Integer goodsId);

    void updateGoodsNum(EmpGoods empGoods);

    void deleteByGoodsId(@Param("empId") Integer empId, @Param("goodsId") Integer goodsId);

    List<EmpGoods> querySelectedGoods(@Param("empId") Integer empId, @Param("goodsId") List<Integer> goodsIdList);
}