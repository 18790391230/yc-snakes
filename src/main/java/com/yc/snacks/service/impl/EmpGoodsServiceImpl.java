package com.yc.snacks.service.impl;

import com.yc.snacks.domain.EmpGoods;
import com.yc.snacks.domain.EmpGroup;
import com.yc.snacks.domain.Goods;
import com.yc.snacks.domain.Order;
import com.yc.snacks.dto.SelectedGoodsListDTO;
import com.yc.snacks.mapper.EmpGoodsMapper;
import com.yc.snacks.mapper.EmpGroupMapper;
import com.yc.snacks.mapper.GoodsMapper;
import com.yc.snacks.mapper.OrderMapper;
import com.yc.snacks.service.EmpGoodsService;
import com.yc.snacks.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
        if (goodsIdList.size() > 0) {
            goodsServiceImpl.getGoodsListByIdList(goodsIdList);
        }
        return null;
    }

    private OrderMapper orderMapper;

    @Autowired
    private EmpGroupMapper empGroupMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public void addGoods2ShoppingCart(Integer empId, Integer goodsId, Integer count) {
        EmpGoods empGoods = empGoodsMapper.selectByGoodsId(empId, goodsId);
        if (empGoods != null) {
            if (empGoods.getGoodsNum() + count > 0) {
                empGoods.setGoodsNum(empGoods.getGoodsNum() + count);
                empGoodsMapper.updateGoodsNum(empGoods);
            }else {
                empGoodsMapper.deleteByGoodsId(empId, goodsId);
            }
        } else {
            empGoods = new EmpGoods();
            empGoods.setGoodsNum(count);
            empGoods.setEmpId(empId);
            empGoods.setGoodsStatus(1);
            empGoodsMapper.insertSelective(empGoods);
        }

    }

    @Override
    public void submitGoodsShopping(Integer empId, List<Integer> goodsIdList) {
        //校验是否超额
        List<EmpGoods> empGoodsList = empGoodsMapper.querySelectedGoods(empId, goodsIdList);
        if (CollectionUtils.isEmpty(empGoodsList)) {
            return;
        }
        Map<Integer, List<EmpGoods>> goods2NumMap = empGoodsList.stream().collect(Collectors.groupingBy(EmpGoods::getGoodsId));
        List<Goods> goodsList = goodsMapper.selectByGoodsIdList(goodsIdList);
        Map<Integer, List<Goods>> goods2PriceMap = goodsList.stream().collect(Collectors.groupingBy(Goods::getId));

        BigDecimal goodsTotal = new BigDecimal(0);
        for (Map.Entry<Integer, List<EmpGoods>> entry : goods2NumMap.entrySet()) {
            List<Goods> goods = goods2PriceMap.get(entry.getKey());
            if (goods != null) {
                BigDecimal bigDecimal = goods.get(0).getGoodsPrice().multiply(new BigDecimal(entry.getValue().get(0).getGoodsNum()));
                goodsTotal = goodsTotal.add(bigDecimal);
            }
        }

        EmpGroup empGroup = empGroupMapper.selectByEmpId(empId);
        BigDecimal usableAmount = empGroup.getEmpAmount().subtract(empGroup.getEmpUsedAmount());
        if (usableAmount.compareTo(goodsTotal) < 0) {
            throw new RuntimeException("超过可用额度！");
        }

        //减少额度
        usableAmount = usableAmount.subtract(goodsTotal);
        empGroup.setEmpUsedAmount(empGroup.getEmpAmount().subtract(usableAmount));
        empGroupMapper.updateUsedAmount(empGroup);

        //查询小组内是否存在已提交但未购买的订单
        Order order = orderMapper.selectByGroupId(empGroup.getGroupId(), 1);
        if (order == null) {
            order =
        }
        //更改购物车状态

//        empGoodsMapper



    }
}
