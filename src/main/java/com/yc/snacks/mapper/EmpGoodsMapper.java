package com.yc.snacks.mapper;

import com.yc.snacks.domain.EmpGoods;

import java.util.List;

/**
 * EmpGoodsMapper继承基类
 */
public interface EmpGoodsMapper extends MyBatisBaseDao<EmpGoods, Integer> {

    List<EmpGoods> selectByOrderIdAndEmpId(Integer orderId, Integer empId);

    List<EmpGoods> selectByOrderIdAndNoEmpId(Integer orderId, Integer empId);
}