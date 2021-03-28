package com.yc.snacks.mapper;

import com.yc.snacks.domain.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * OrderMapper继承基类
 */
public interface OrderMapper extends MyBatisBaseDao<Order, Integer> {

    Order selectByGroupId(Integer groupId);

    Order selectLatestOrderByGroupId(@Param("groupId") Integer groupId);

    Order selectLatestOrderByGroupIdAndStatus(@Param("groupId") Integer groupId, @Param("status") Integer status);

    List<Order> selectUnCompletedOrdersByGroupId(@Param("groupId") Integer groupId);

    Order selectByGroupId(@Param("groupId") Integer groupId, @Param("orderStatus") int orderStatus);

    int updateOrderStatus(@Param("orderId") Integer orderId, @Param("status") int orderStatus);

    int updateAmountAndGoodNum(Order order);
}