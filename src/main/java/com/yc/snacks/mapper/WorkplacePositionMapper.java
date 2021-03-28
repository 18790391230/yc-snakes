package com.yc.snacks.mapper;

import com.yc.snacks.domain.WorkplacePosition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * WorkplacePositionMapper继承基类
 */
public interface WorkplacePositionMapper extends MyBatisBaseDao<WorkplacePosition, Integer> {

    List<WorkplacePosition> selectByIdList(@Param("idList") List<Integer> idList);
}