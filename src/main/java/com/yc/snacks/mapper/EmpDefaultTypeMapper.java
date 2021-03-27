package com.yc.snacks.mapper;

import com.yc.snacks.domain.EmpDefaultType;
import org.apache.ibatis.annotations.Param;

/**
 * EmpDefaultTypeMapper继承基类
 */
public interface EmpDefaultTypeMapper extends MyBatisBaseDao<EmpDefaultType, Integer> {
    EmpDefaultType selectByEmpId(@Param("empId") int empId, @Param("tag") Integer tag);
}