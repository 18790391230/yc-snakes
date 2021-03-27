package com.yc.snacks.mapper;

import com.yc.snacks.domain.Order;

/**
 * OrderMapper继承基类
 */
public interface OrderMapper extends MyBatisBaseDao<Order, Integer> {

    Order selectByGroupId(Integer groupId);

}