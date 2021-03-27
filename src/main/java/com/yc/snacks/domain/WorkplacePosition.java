package com.yc.snacks.domain;

import java.io.Serializable;

/**
 * @author 
 * 
 */
public class WorkplacePosition implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 职场名称
     */
    private String name;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}