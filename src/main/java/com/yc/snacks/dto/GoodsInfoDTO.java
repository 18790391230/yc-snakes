package com.yc.snacks.dto;

import java.math.BigDecimal;

public class GoodsInfoDTO {

    private Integer goodsId;

    private String goodsName;

    private String goodsPicUrl;

    private Integer goodsNum;

    private String linkId;

    private BigDecimal price;

    public GoodsInfoDTO() {
    }

    public GoodsInfoDTO(Integer goodsId, String goodsName, String goodsPicUrl, Integer goodsNum, String linkId, BigDecimal price) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsPicUrl = goodsPicUrl;
        this.goodsNum = goodsNum;
        this.linkId = linkId;
        this.price = price;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsPicUrl() {
        return goodsPicUrl;
    }

    public void setGoodsPicUrl(String goodsPicUrl) {
        this.goodsPicUrl = goodsPicUrl;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
