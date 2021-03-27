package com.yc.snacks.service.impl;

import com.yc.snacks.domain.Goods;
import com.yc.snacks.mapper.GoodsMapper;
import com.yc.snacks.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> getGoodsListByIdList(List<Integer> idList) throws Exception {
        List<Goods> goodsList = goodsMapper.selectByIdList(idList);
        if(null == goodsList){
            return new ArrayList<>();
        }
        return goodsList;
    }
}
