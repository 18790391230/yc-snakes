package com.yc.snacks.service;

import java.util.List;

public interface EmpGoodsService {

    void addGoods2ShoppingCart(Integer empId, Integer goodsId, Integer count);

    void submitGoodsShopping(Integer empId, List<Integer> goodsIdList)
}
