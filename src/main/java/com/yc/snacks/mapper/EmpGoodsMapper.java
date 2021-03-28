package com.yc.snacks.mapper;

import com.yc.snacks.domain.EmpGoods;
import com.yc.snacks.domain.GoodTypeNameSale;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import java.util.List;

/**
 * EmpGoodsMapper继承基类
 */
public interface EmpGoodsMapper extends MyBatisBaseDao<EmpGoods, Integer> {

    List<EmpGoods> selectByOrderIdAndEmpId(Integer orderId, Integer empId);

    List<EmpGoods> selectByOrderIdAndNoEmpId(Integer orderId, Integer empId);

    EmpGoods selectByGoodsId(@Param("empId") Integer empId, @Param("goodsId") Integer goodsId);

    int updateGoodsNum(EmpGoods empGoods);

    int deleteByGoodsId(@Param("empId") Integer empId, @Param("goodsId") Integer goodsId);

    List<EmpGoods> querySelectedGoods(@Param("empId") Integer empId, @Param("goodsIdList") List<Integer> goodsIdList);

    int updateOrderId(@Param("empId") Integer empId, @Param("goodsIdList") List<Integer> goodsIdList,
                       @Param("orderId") Integer orderId);

    int updateGoodsStatus(@Param("empId") Integer empId, @Param("goodsIdList") List<Integer> goodsIdList, @Param("goodsStatus") int goodsStatus);

    List<GoodTypeNameSale> selectGoodTypeSale();
}