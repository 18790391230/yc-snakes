package com.yc.snacks.service;

import com.yc.snacks.domain.GoodTypeNameSale;
import com.yc.snacks.dto.OrderListDTO;
import com.yc.snacks.dto.SelectedGoodsListDTO;

import java.util.List;

public interface EmpGoodsService {

    List<OrderListDTO> getSelectedGoodsList(Integer empId) throws Exception;

    void addGoods2ShoppingCart(Integer empId, Integer goodsId, Integer count);

    void submitGoodsShopping(Integer empId, List<Integer> goodsIdList);

    List<GoodTypeNameSale> queryGoodsHeatRankingList(Integer topCount);

    SelectedGoodsListDTO getGoodsByGroupId(Integer groupId, Integer payStatus) throws Exception;
}
