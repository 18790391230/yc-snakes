package com.yc.snacks.service;

import com.yc.snacks.domain.EmpGoodsExpenseInfo;
import com.yc.snacks.domain.EmpGroup;

import java.util.List;

public interface EmpGroupService {

    EmpGroup getGroupIdByEmpId(Integer empId) throws Exception;

    List<EmpGoodsExpenseInfo> selectEmpGoodsExpenseInfo();
}
