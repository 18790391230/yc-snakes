package com.yc.snacks.service;

import com.yc.snacks.dto.SelectedGoodsListDTO;
import com.yc.snacks.domain.GoodTypeNameSale;

import java.util.List;

public interface EmpGoodsService {

    SelectedGoodsListDTO getSelectedGoodsList(Integer orderId, Integer empId) throws Exception;

    void addGoods2ShoppingCart(Integer empId, Integer goodsId, Integer count);

    void submitGoodsShopping(Integer empId, List<Integer> goodsIdList);

    List<GoodTypeNameSale> queryGoodsHeatRankingList(Integer topCount);
}
