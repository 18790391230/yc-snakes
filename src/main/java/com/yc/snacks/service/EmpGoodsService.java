package com.yc.snacks.service;

import com.yc.snacks.dto.SelectedGoodsListDTO;
import java.util.List;

public interface EmpGoodsService {

    SelectedGoodsListDTO getSelectedGoodsList(Integer empId) throws Exception;

    void addGoods2ShoppingCart(Integer empId, Integer goodsId, Integer count);

    void submitGoodsShopping(Integer empId, List<Integer> goodsIdList);

    SelectedGoodsListDTO getGoodsByGroupId(Integer groupId) throws Exception;
}
