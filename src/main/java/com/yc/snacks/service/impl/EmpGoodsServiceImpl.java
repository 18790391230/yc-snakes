package com.yc.snacks.service.impl;

import com.yc.snacks.domain.*;
import com.yc.snacks.dto.GoodsInfoDTO;
import com.yc.snacks.dto.OrderListDTO;
import com.yc.snacks.dto.SelectedGoodsListDTO;
import com.yc.snacks.mapper.EmpGoodsMapper;
import com.yc.snacks.mapper.EmpGroupMapper;
import com.yc.snacks.mapper.GoodsMapper;
import com.yc.snacks.mapper.OrderMapper;
import com.yc.snacks.service.EmpGoodsService;
import com.yc.snacks.service.EmpGroupService;
import com.yc.snacks.service.GoodsService;
import com.yc.snacks.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

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

    @Autowired
    private OrderService orderServiceImpl;

    @Autowired
    private EmpGroupService empGroupService;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private EmpGroupMapper empGroupMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<OrderListDTO> getSelectedGoodsList(Integer empId) throws Exception {
        List<OrderListDTO> result = new ArrayList<>();
        try {
            EmpGroup empGroup = empGroupService.getGroupIdByEmpId(empId);
            if(empGroup != null){
                Integer groupId = empGroup.getGroupId();
                List<Order> orderList = orderServiceImpl.getUnCompletedOrdersByGroupId(groupId);
//                List<Integer> orderIdList = orderList.stream().map(Order::getId).collect(Collectors.toList());
                List<Integer> goodsIdList = new ArrayList<>();
                for(Order order : orderList){
                    OrderListDTO dto = new OrderListDTO();
                    Integer orderId = order.getId();
                    List<EmpGoods> ownerList = empGoodsMapper.selectByOrderIdAndEmpId(orderId, empId);
                    goodsIdList.addAll(ownerList.stream().map(EmpGoods::getGoodsId).collect(Collectors.toList()));
                    List<EmpGoods> otherList = empGoodsMapper.selectByOrderIdAndNoEmpId(orderId, empId);
                    goodsIdList.addAll(otherList.stream().map(EmpGoods::getGoodsId).collect(Collectors.toList()));
                    if (goodsIdList.size() > 0) {
                        List<Goods> goodsList = goodsServiceImpl.getGoodsListByIdList(goodsIdList);
                        Map<Integer, Goods> goodsMap = goodsList.stream().collect(Collectors.toMap(Goods::getId, goods-> goods));
                        List<GoodsInfoDTO> owner = new ArrayList<>();
                        List<GoodsInfoDTO> other = new ArrayList<>();
                        for(EmpGoods empGoods : ownerList){
                            Integer goodsId = empGoods.getGoodsId();
                            Integer goodsNum = empGoods.getGoodsNum();
                            Goods goods = goodsMap.get(goodsId);
                            String goodsName = goods.getName();
                            String goodsPic = goods.getPicUrl();
                            String linkId = goods.getLinkId();
                            BigDecimal price = goods.getGoodsPrice();
                            GoodsInfoDTO dto1 = new GoodsInfoDTO(goodsId, goodsName, goodsPic, goodsNum, linkId, price);
                            owner.add(dto1);
                        }
                        for(EmpGoods empGoods : otherList){
                            Integer goodsId = empGoods.getGoodsId();
                            Integer goodsNum = empGoods.getGoodsNum();
                            Goods goods = goodsMap.get(goodsId);
                            String goodsName = goods.getName();
                            String goodsPic = goods.getPicUrl();
                            String linkId = goods.getLinkId();
                            BigDecimal price = goods.getGoodsPrice();
                            GoodsInfoDTO dto2 = new GoodsInfoDTO(goodsId, goodsName, goodsPic, goodsNum, linkId, price);
                            other.add(dto2);
                        }
                        dto.setGroupId(groupId);
                        dto.setOrderId(orderId);
                        dto.setGoodsAmount(order.getOrderAmount());
                        dto.setGoodsNum(order.getGoodsNum());
                        dto.setOtherList(other);
                        dto.setOtherList(owner);
                        result.add(dto);
                    }

                }
            }
        }catch (Exception e){
            throw new IllegalArgumentException("get datas error");
        }
        return result;
    }

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

    @Transactional
    @Override
    public void submitGoodsShopping(Integer empId, List<Integer> goodsIdList) {
        //??????????????????
        List<EmpGoods> empGoodsList = empGoodsMapper.querySelectedGoods(empId, goodsIdList);
        if (CollectionUtils.isEmpty(empGoodsList)) {
            return;
        }
        Map<Integer, List<EmpGoods>> goods2NumMap = empGoodsList.stream().collect(Collectors.groupingBy(EmpGoods::getGoodsId));
        List<Goods> goodsList = goodsMapper.selectByGoodsIdList(goodsIdList);
        Map<Integer, List<Goods>> goods2PriceMap = goodsList.stream().collect(Collectors.groupingBy(Goods::getId));

        BigDecimal goodsTotal = new BigDecimal(0);
        int goodsNum = 0;
        for (Map.Entry<Integer, List<EmpGoods>> entry : goods2NumMap.entrySet()) {
            goodsNum += entry.getValue().get(0).getGoodsNum();
            List<Goods> goods = goods2PriceMap.get(entry.getKey());
            if (goods != null) {
                BigDecimal bigDecimal = goods.get(0).getGoodsPrice().multiply(new BigDecimal(entry.getValue().get(0).getGoodsNum()));
                goodsTotal = goodsTotal.add(bigDecimal);
            }
        }

        EmpGroup empGroup = empGroupMapper.selectByEmpId(empId);
        BigDecimal usableAmount = empGroup.getEmpAmount().subtract(empGroup.getEmpUsedAmount());
        if (usableAmount.compareTo(goodsTotal) < 0) {
            throw new RuntimeException("?????????????????????");
        }

        //????????????
        usableAmount = usableAmount.subtract(goodsTotal);
        empGroup.setEmpUsedAmount(empGroup.getEmpAmount().subtract(usableAmount));
        empGroup.setEmpTotalUsedAmount(empGroup.getEmpTotalUsedAmount().add(goodsTotal));
        empGroupMapper.updateUsedAmount(empGroup);

        //?????????????????????????????????????????????????????????
        Order order = orderMapper.selectByGroupId(empGroup.getGroupId(), 1);
        if (order == null) {
            order = new Order();
            order.setGoodsNum(goodsNum);
            order.setGroupId(empGroup.getGroupId());
            order.setOrderStatus(1);
            order.setOrderAmount(goodsTotal);
            orderMapper.insertSelective(order);
        }else{
            order.setGoodsNum(order.getGoodsNum() + goodsNum);
            order.setOrderAmount(order.getOrderAmount().add(goodsTotal));
        }
        orderMapper.updateAmountAndGoodNum(order);
        empGoodsMapper.updateOrderId(empId, goodsIdList, order.getId());

        //?????????????????????
        empGoodsMapper.updateGoodsStatus(empId, goodsIdList, 2);
    }

    @Override
    public List<GoodTypeNameSale> queryGoodsHeatRankingList(Integer topCount) {
        List<GoodTypeNameSale> goodTypeNameSales = empGoodsMapper.selectGoodTypeSale();
//        List<GoodTypeNameSale> rtnList = new ArrayList<>();
        for (GoodTypeNameSale goodTypeNameSale : goodTypeNameSales) {
            List<GoodsSale> goodsSaleList = goodTypeNameSale.getGoodsSaleList();
            if (!CollectionUtils.isEmpty(goodsSaleList)) {
                goodTypeNameSale.setGoodsSaleList(goodsSaleList.size() > topCount
                        ? goodsSaleList.subList(0, topCount)
                        : goodsSaleList);
            }
        }

        return goodTypeNameSales;
    }


    @Override
    public SelectedGoodsListDTO getGoodsByGroupId(Integer groupId, Integer payStatus) throws Exception {
        SelectedGoodsListDTO result = new SelectedGoodsListDTO();
        Order order = orderServiceImpl.getCurrentOrderByGroupIdAndStatus(groupId, payStatus);
        if(null == order){
            return null;
        }
        Integer orderId = order.getId();
        BigDecimal orderAmount = order.getOrderAmount();
        Integer goodsNum = order.getGoodsNum();
        List<EmpGoods> empGoodsList = empGoodsMapper.selectByOrderId(orderId);
        if(ObjectUtils.isEmpty(empGoodsList)){
            return null;
        }
        List<Integer> goodsIdList = empGoodsList.stream().map(EmpGoods::getGoodsId).collect(Collectors.toList());
        List<Goods> goodsList = goodsServiceImpl.getGoodsListByIdList(goodsIdList);
        Map<Integer, Goods> goodsMap = goodsList.stream().collect(Collectors.toMap(Goods::getId, goods -> goods));
        List<GoodsInfoDTO> goodsInfoDTOList = new ArrayList<>();
        for(EmpGoods empGoods : empGoodsList){
            Integer goodsId = empGoods.getGoodsId();
            Integer goodsNum1= empGoods.getGoodsNum();
            Goods goods = goodsMap.get(goodsId);
            String goodsName = goods.getName();
            String goodsPic = goods.getPicUrl();
            String linkId = goods.getLinkId();
            BigDecimal price = goods.getGoodsPrice();
            GoodsInfoDTO dto = new GoodsInfoDTO(goodsId, goodsName, goodsPic, goodsNum1, linkId, price);
            goodsInfoDTOList.add(dto);
        }
        result.setGroupList(goodsInfoDTOList);
        result.setGoodsNum(goodsNum);
        result.setGoodsAmount(orderAmount);
        result.setGroupId(groupId);
        result.setOrderId(orderId);
        return result;
    }
}
