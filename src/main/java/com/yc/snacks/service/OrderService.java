package com.yc.snacks.service;

import com.yc.snacks.domain.Order;

public interface OrderService {

    Order getCurrentOrderByGroupId(Integer groupId) throws Exception;
}
