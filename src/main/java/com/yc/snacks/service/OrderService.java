package com.yc.snacks.service;

import com.yc.snacks.domain.Order;

import java.util.List;

public interface OrderService {

    Order getCurrentOrderByGroupId(Integer groupId) throws Exception;

    Order getCurrentOrderByGroupIdAndStatus(Integer groupId, Integer status) throws Exception;

    int updateOrderStatus(Integer orderId, Integer empId, Integer status) throws Exception;

    List<Order> getUnCompletedOrdersByGroupId(Integer groupId) throws Exception;



}
