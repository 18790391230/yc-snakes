package com.yc.snacks.service.impl;

import com.yc.snacks.domain.Order;
import com.yc.snacks.mapper.OrderMapper;
import com.yc.snacks.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

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
    }
}
