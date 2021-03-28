package com.yc.snacks.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderListDTO {

    private Integer groupId;

    private Integer orderId;

    private List<GoodsInfoDTO> ownerList;

    private List<GoodsInfoDTO> otherList;

    private Integer goodsNum;

    private BigDecimal goodsAmount;
}
