package com.yc.snacks.service;

import com.yc.snacks.domain.EmpGroup;

public interface EmpGroupService {

    EmpGroup getGroupIdByEmpId(Integer empId) throws Exception;
}
