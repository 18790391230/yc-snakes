package com.yc.snacks.service;

import com.yc.snacks.dto.SelectedGoodsListDTO;

public interface EmpGoodsService {

    SelectedGoodsListDTO getSelectedGoodsList(Integer orderId, Integer empId) throws Exception;


}
