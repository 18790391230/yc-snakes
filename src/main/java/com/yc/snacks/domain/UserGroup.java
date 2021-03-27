package com.yc.snacks.domain;

import java.io.Serializable;

/**
 * @author 
 * 
 */
public class UserGroup implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 所属职场id
     */
    private Integer positionId;

    /**
     * 组别名称
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}