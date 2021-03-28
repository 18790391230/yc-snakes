package com.yc.snacks.domain;

import java.util.List;

public class GoodTypeNameSale {

    private String goodsTypeName;

    private List<GoodsSale> goodsSaleList;

    public String getGoodsTypeName() {
        return goodsTypeName;
    }

    public void setGoodsTypeName(String goodsTypeName) {
        this.goodsTypeName = goodsTypeName;
    }

    public List<GoodsSale> getGoodsSaleList() {
        return goodsSaleList;
    }

    public void setGoodsSaleList(List<GoodsSale> goodsSaleList) {
        this.goodsSaleList = goodsSaleList;
    }
}
