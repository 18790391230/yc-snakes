package com.yc.snacks.domain;

import java.io.Serializable;

/**
 * @author 
 * 
 */
public class GoodsType implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 京东上商品类型
     */
    private Integer goodsType;

    /**
     * 商品类型名称
     */
    private String goodsTypeName;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsTypeName() {
        return goodsTypeName;
    }

    public void setGoodsTypeName(String goodsTypeName) {
        this.goodsTypeName = goodsTypeName;
    }
}