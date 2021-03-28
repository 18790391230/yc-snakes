package com.yc.snacks.domain;

import java.math.BigDecimal;

public class EmpGoodsExpenseInfo {

    private String workplaceName;

    private String groupName;

    public String getWorkplaceName() {
        return workplaceName;
    }

    public void setWorkplaceName(String workplaceName) {
        this.workplaceName = workplaceName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

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

    private BigDecimal empTotalUsedAmount;


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

    public BigDecimal getEmpTotalUsedAmount() {
        return empTotalUsedAmount;
    }

    public void setEmpTotalUsedAmount(BigDecimal empTotalUsedAmount) {
        this.empTotalUsedAmount = empTotalUsedAmount;
    }
}
