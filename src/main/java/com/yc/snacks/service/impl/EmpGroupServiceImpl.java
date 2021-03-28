package com.yc.snacks.service.impl;

import com.yc.snacks.domain.EmpGroup;
import com.yc.snacks.mapper.EmpGroupMapper;
import com.yc.snacks.service.EmpGroupService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class EmpGroupServiceImpl implements EmpGroupService {

    @Autowired
    public EmpGroupMapper empGroupMapper;

    @Override
    public EmpGroup getGroupIdByEmpId(Integer empId) throws Exception {
        EmpGroup empGroup = empGroupMapper.selectByEmpId(empId);
        if (!ObjectUtils.isEmpty(empGroup)){
            return empGroup;
        } else {
            throw new IllegalArgumentException("empId has no matched object");
        }
    }
}
