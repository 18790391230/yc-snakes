package com.yc.snacks.service;

import com.yc.snacks.domain.Goods;

import java.util.List;

public interface GoodsService {

    List<Goods> getGoodsListByIdList(List<Integer> idList) throws Exception;
    List<Goods> selectByType(Integer goodsType);
}
