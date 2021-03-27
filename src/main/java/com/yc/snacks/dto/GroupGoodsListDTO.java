package com.yc.snacks.dto;

import java.math.BigDecimal;
import java.util.List;

public class GroupGoodsListDTO {

    private Integer goodsNum;

    private BigDecimal goodsAmount;

    private List<GoodsInfoDTO> goodsList;

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public BigDecimal getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(BigDecimal goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public List<GoodsInfoDTO> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsInfoDTO> goodsList) {
        this.goodsList = goodsList;
    }
}
