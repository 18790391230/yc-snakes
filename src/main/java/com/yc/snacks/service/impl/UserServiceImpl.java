package com.yc.snacks.service.impl;

import com.yc.snacks.domain.EmpGroup;
import com.yc.snacks.mapper.EmpGroupMapper;
import com.yc.snacks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private EmpGroupMapper empGroupMapper;

    @Override
    public boolean firstLogin(int empId) {

        EmpGroup empGroup = empGroupMapper.selectByEmpId(empId);

        return empGroup.getFirstLogin() != 1;
    }

    @Override
    public void saveUserTags(List<String> tags) {


//        empGroupMapper.insertSelective()
    }
}
