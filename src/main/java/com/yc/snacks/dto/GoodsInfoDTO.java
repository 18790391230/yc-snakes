package com.yc.snacks.dto;

public class GoodsInfoDTO {

    private Integer goodsId;

    private String goodsName;

    private String goodsPicUrl;

    private Integer goodsNum;

    public GoodsInfoDTO() {
    }

    public GoodsInfoDTO(Integer goodsId, String goodsName, String goodsPicUrl, Integer goodsNum) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsPicUrl = goodsPicUrl;
        this.goodsNum = goodsNum;
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
}
