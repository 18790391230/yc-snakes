package com.yc.snacks.service.impl;

import com.yc.snacks.domain.EmpDefaultType;
import com.yc.snacks.domain.EmpGroup;
import com.yc.snacks.domain.GoodsType;
import com.yc.snacks.mapper.EmpDefaultTypeMapper;
import com.yc.snacks.mapper.EmpGroupMapper;
import com.yc.snacks.mapper.GoodsTypeMapper;
import com.yc.snacks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private EmpGroupMapper empGroupMapper;

    @Autowired
    private EmpDefaultTypeMapper empDefaultTypeMapper;

    @Autowired
    private GoodsTypeMapper goodsTypeMapper;

    @Override
    public boolean firstLogin(int empId) {

        EmpGroup empGroup = empGroupMapper.selectByEmpId(empId);

        return empGroup.getFirstLogin() != 1;
    }

    @Override
    public void saveUserTags(int empId, List<Integer> goodsTypeIds) {
        List<GoodsType> goodsTypeList = goodsTypeMapper.selectAll();
        if (CollectionUtils.isEmpty(goodsTypeList)) {
            return;
        }
        Map<Integer, List<GoodsType>> collect = goodsTypeList.stream().collect(Collectors.groupingBy(GoodsType::getId));
        for (Integer typeId : goodsTypeIds) {
            EmpDefaultType empDefaultType = empDefaultTypeMapper.selectByEmpId(empId, typeId);
            if (empDefaultType == null) {
                EmpDefaultType defaultType = new EmpDefaultType();
                defaultType.setTypeId(typeId);
                defaultType.setTypeName(collect.get(typeId).get(0).getGoodsTypeName());
                defaultType.setEmpId(empId);
                empDefaultTypeMapper.insertSelective(defaultType);
            }

        }
    }

    @Override
    public void updateLoginStatus(int empId) {
        empGroupMapper.updateLoginStatus(empId);
    }
}
