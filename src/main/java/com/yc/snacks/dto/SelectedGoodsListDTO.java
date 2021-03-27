package com.yc.snacks.dto;

import java.util.List;

public class SelectedGoodsListDTO {

    private List<GoodsInfoDTO> ownerList;

    private List<GoodsInfoDTO> otherList;

    public SelectedGoodsListDTO(List<GoodsInfoDTO> ownerList, List<GoodsInfoDTO> otherList) {
        this.ownerList = ownerList;
        this.otherList = otherList;
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
}
