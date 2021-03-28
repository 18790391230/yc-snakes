package com.yc.snacks.dto;

import java.math.BigDecimal;
import java.util.List;

public class SelectedGoodsListDTO {

    private Integer groupId;

    private Integer orderId;

    private List<GoodsInfoDTO> ownerList;

    private List<GoodsInfoDTO> otherList;

    private List<GoodsInfoDTO> groupList;

    private Integer goodsNum;

    private BigDecimal goodsAmount;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public List<GoodsInfoDTO> getOwnerList() {
        return ownerList;
    }

    public void setOwnerList(List<GoodsInfoDTO> ownerList) {
        this.ownerList = ownerList;
    }

    public List<GoodsInfoDTO> getOtherList() {
        return otherList;
    }

    public void setOtherList(List<GoodsInfoDTO> otherList) {
        this.otherList = otherList;
    }

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

    public List<GoodsInfoDTO> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<GoodsInfoDTO> groupList) {
        this.groupList = groupList;
    }
}
