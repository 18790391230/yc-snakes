package com.yc.snacks.domain;

import java.io.Serializable;

/**
 * @author 
 * 
 */
public class EmpDefaultType implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 员工id
     */
    private Integer empId;

    /**
     * 喜爱商品类型
     */
    private Integer typeId;

    /**
     * 喜爱商品类型名称
     */
    private String typeName;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}