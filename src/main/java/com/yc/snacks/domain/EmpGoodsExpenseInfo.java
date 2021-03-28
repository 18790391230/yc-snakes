package com.yc.snacks.domain;

import java.math.BigDecimal;

public class EmpGoodsExpenseInfo {

    private String companyName;
    private String departmentName;
    private String workplaceName;

    private String groupName;

    private BigDecimal yearBudgetAmount;

    private Double usedRate;


    /**
     * 员工名称
     */
    private String empName;

    /**
     * 员工id
     */
    private Integer empId;


    /**
     * 员工当月额度
     */
    private BigDecimal empAmount;

    /**
     * 员工已用额度
     */
    private BigDecimal empUsedAmount;

    private BigDecimal empTotalUsedAmount;
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public BigDecimal getYearBudgetAmount() {
        return yearBudgetAmount;
    }

    public void setYearBudgetAmount(BigDecimal yearBudgetAmount) {
        this.yearBudgetAmount = yearBudgetAmount;
    }

    public Double getUsedRate() {
        return usedRate;
    }

    public void setUsedRate(Double usedRate) {
        this.usedRate = usedRate;
    }

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
