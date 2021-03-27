package com.yc.snacks.mapper;

import com.yc.snacks.domain.EmpGroup;

/**
 * EmpGroupMapper继承基类
 */
public interface EmpGroupMapper extends MyBatisBaseDao<EmpGroup, Integer> {
    EmpGroup selectByEmpId(int empId);

    void updateLoginStatus(int empId);

    void updateUsedAmount(EmpGroup empGroup);
}