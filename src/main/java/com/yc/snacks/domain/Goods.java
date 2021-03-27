package com.yc.snacks.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 
 * 
 */
public class Goods implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 商品类别
     */
    private Integer goodsTypeId;

    /**
     * 京东商品关联id
     */
    private Integer linkId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品图片地址
     */
    private String picUrl;

    /**
     * 商品描述
     */
    private String goodsDesc;

    /**
     * 商品价格
     */
    private BigDecimal goodsPrice;

    /**
     * 商品热量
     */
    private Integer calValue;

    /**
     * 商品描述
     */
    private String remark;

    /**
     * 商品排行
     */
    private Integer rankNo;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(Integer goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getCalValue() {
        return calValue;
    }

    public void setCalValue(Integer calValue) {
        this.calValue = calValue;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getRankNo() {
        return rankNo;
    }

    public void setRankNo(Integer rankNo) {
        this.rankNo = rankNo;
    }
}