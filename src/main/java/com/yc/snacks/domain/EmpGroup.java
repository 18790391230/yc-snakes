package com.yc.snacks.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 
 * 
 */
public class EmpGroup implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 组别id
     */
    private Integer groupId;

    /**
     * 员工名称
     */
    private String empName;

    /**
     * 员工id
     */
    private Integer empId;

    /**
     * 员工角色，1普通角色  2团队负责人  3采购员
     */
    private Integer empRoleFlag;

    /**
     * 员工当月额度
     */
    private BigDecimal empAmount;

    /**
     * 员工已用额度
     */
    private BigDecimal empUsedAmount;

    /**
     * 创建时间
     */
    private Date createTime;

    private BigDecimal empTotalUsedAmount;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否第一次登陆
     */
    private Integer firstLogin;

    public BigDecimal getEmpTotalUsedAmount() {
        return empTotalUsedAmount;
    }

    public void setEmpTotalUsedAmount(BigDecimal empTotalUsedAmount) {
        this.empTotalUsedAmount = empTotalUsedAmount;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getEmpRoleFlag() {
        return empRoleFlag;
    }

    public void setEmpRoleFlag(Integer empRoleFlag) {
        this.empRoleFlag = empRoleFlag;
    }

    public BigDecimal getEmpAmount() {
        return empAmount;
    }

    public void setEmpAmount(BigDecimal empAmount) {
        this.empAmount = empAmount;
    }

    public BigDecimal getEmpUsedAmount() {
        return empUsedAmount;
    }

    public void setEmpUsedAmount(BigDecimal empUsedAmount) {
        this.empUsedAmount = empUsedAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(Integer firstLogin) {
        this.firstLogin = firstLogin;
    }
}