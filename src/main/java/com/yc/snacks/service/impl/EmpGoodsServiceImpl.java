package com.yc.snacks.service.impl;

import com.yc.snacks.domain.EmpGoods;
import com.yc.snacks.mapper.EmpGoodsMapper;
import com.yc.snacks.service.EmpGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpGoodsServiceImpl implements EmpGoodsService {

    @Autowired
    private EmpGoodsMapper empGoodsMapper;

    @Override
    public void addGoods2ShoppingCart(Integer empId, Integer goodsId, Integer count) {
        EmpGoods empGoods = empGoodsMapper.selectByGoodsId(empId, goodsId);
        if (empGoods != null) {
            if (empGoods.getGoodsNum() + count > 0) {
                empGoods.setGoodsNum(empGoods.getGoodsNum() + count);
                empGoodsMapper.updateByGoodsId(empId, goodsId);
            }else {
                empGoodsMapper.deleteByGoodsId(empId, goodsId);
            }
        } else {
            empGoods = new EmpGoods();
            empGoods.setGoodsNum(count);
            empGoods.setEmpId(empId);
            empGoods.setGoodsStatus(1);
            empGoodsMapper.insertSelective(empGoods);
        }

    }
}
