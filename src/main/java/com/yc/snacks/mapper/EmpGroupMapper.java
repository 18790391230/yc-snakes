package com.yc.snacks.mapper;

import com.yc.snacks.domain.EmpGoodsExpenseInfo;
import com.yc.snacks.domain.EmpGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * EmpGroupMapper继承基类
 */
public interface EmpGroupMapper extends MyBatisBaseDao<EmpGroup, Integer> {
    EmpGroup selectByEmpId(@Param(value = "empId") int empId);

    void updateLoginStatus(int empId);

    void updateUsedAmount(EmpGroup empGroup);

    List<EmpGoodsExpenseInfo> selectEmpGoodsExpenseInfo();
}