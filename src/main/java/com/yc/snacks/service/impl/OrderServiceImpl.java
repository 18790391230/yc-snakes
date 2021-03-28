package com.yc.snacks.service.impl;

import com.yc.snacks.domain.EmpGroup;
import com.yc.snacks.domain.Order;
import com.yc.snacks.mapper.EmpGoodsMapper;
import com.yc.snacks.mapper.OrderMapper;
import com.yc.snacks.service.EmpGroupService;
import com.yc.snacks.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private EmpGroupService empGroupServiceImpl;

    @Autowired
    private EmpGoodsMapper empGoodsMapper;



    @Override
    public Order getCurrentOrderByGroupId(Integer groupId) throws Exception {
        Order order = orderMapper.selectLatestOrderByGroupId(groupId);
        if(order != null){
            Integer status = order.getOrderStatus();
            if(status == 4){
                return null;
            }else{
                return order;
            }
        }
        return null;
    }

    @Override
    public Order getCurrentOrderByGroupIdAndStatus(Integer groupId, Integer status) throws Exception {
        Order order = orderMapper.selectLatestOrderByGroupIdAndStatus(groupId, status);
        if(status.equals(2)){
            if(order == null){
                order = orderMapper.selectLatestOrderByGroupIdAndStatus(groupId, 3);
                if(order == null){
                    orderMapper.selectLatestOrderByGroupIdAndStatus(groupId, 4);
                }
            }
        }
        return order;
    }

    @Override
    public int updateOrderStatus(Integer orderId, Integer empId, Integer status) throws Exception {
        EmpGroup empGroup = empGroupServiceImpl.getGroupIdByEmpId(empId);
        int result = 0;
        if(empGroup == null){
            return result;
        }
        Integer roleFlag = empGroup.getEmpRoleFlag();
        if(roleFlag.equals(3) && status.equals(1)){
            result = orderMapper.updateOrderStatus(orderId, 2);
            empGoodsMapper.updateGoodsStatusByOrderId(orderId, 3);
        }else if(roleFlag.equals(3) && status.equals(3)){
            result = orderMapper.updateOrderStatus(orderId, 4);
        }else if(roleFlag.equals(2) && status.equals(2)){
            result = orderMapper.updateOrderStatus(orderId, 3);
        }
        return result;
    }

    @Override
    public List<Order> getUnCompletedOrdersByGroupId(Integer groupId) throws Exception {
        List<Order> orderList = orderMapper.selectUnCompletedOrdersByGroupId(groupId);
        return orderList;
    }
}
