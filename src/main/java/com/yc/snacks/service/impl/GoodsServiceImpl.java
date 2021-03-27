package com.yc.snacks.service.impl;

import com.yc.snacks.domain.Goods;
import com.yc.snacks.mapper.GoodsMapper;
import com.yc.snacks.mapper.GoodsTypeMapper;
import com.yc.snacks.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> selectByType(Integer goodsType) {

        return goodsMapper.selectByType(goodsType);
    }
}
