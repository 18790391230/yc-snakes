package com.yc.snacks.service.impl;

import com.yc.snacks.domain.EmpGoods;
import com.yc.snacks.dto.SelectedGoodsListDTO;
import com.yc.snacks.mapper.EmpGoodsMapper;
import com.yc.snacks.service.EmpGoodsService;
import com.yc.snacks.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpGoodsServiceImpl implements EmpGoodsService {

    @Autowired
    private EmpGoodsMapper empGoodsMapper;

    @Autowired
    private GoodsService goodsServiceImpl;

    @Override
    public SelectedGoodsListDTO getSelectedGoodsList(Integer orderId, Integer empId) throws Exception {
        List<Integer> goodsIdList = new ArrayList<>();
        List<EmpGoods> ownerList = empGoodsMapper.selectByOrderIdAndEmpId(orderId, empId);
        goodsIdList.addAll(ownerList.stream().map(EmpGoods::getGoodsId).collect(Collectors.toList()));
        List<EmpGoods> otherList = empGoodsMapper.selectByOrderIdAndNoEmpId(orderId, empId);
        goodsIdList.addAll(otherList.stream().map(EmpGoods::getGoodsId).collect(Collectors.toList()));
        if(goodsIdList.size() > 0){
            goodsServiceImpl.getGoodsListByIdList(goodsIdList);
        }
        return null;
    }
}
