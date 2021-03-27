package com.yc.snacks.mapper;

import com.yc.snacks.domain.Order;
import org.apache.ibatis.annotations.Param;

/**
 * OrderMapper继承基类
 */
public interface OrderMapper extends MyBatisBaseDao<Order, Integer> {

    Order selectByGroupId(@Param("groupId") Integer groupId, @Param("orderStatus") int orderStatus);
}