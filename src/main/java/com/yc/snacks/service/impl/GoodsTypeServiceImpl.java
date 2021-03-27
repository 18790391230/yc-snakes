package com.yc.snacks.service.impl;

import com.yc.snacks.domain.GoodsType;
import com.yc.snacks.mapper.GoodsTypeMapper;
import com.yc.snacks.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Autowired
    private GoodsTypeMapper goodsTypeMapper;

    @Override
    public List<GoodsType> selectAll() {
        return goodsTypeMapper.selectAll();
    }
}
