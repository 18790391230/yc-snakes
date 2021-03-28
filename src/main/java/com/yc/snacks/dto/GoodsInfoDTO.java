package com.yc.snacks.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsInfoDTO {

    private Integer goodsId;

    private String goodsName;

    private String goodsPicUrl;

    private Integer goodsNum;

    private String linkId;

    private BigDecimal price;
}
