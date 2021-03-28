package com.yc.snacks.mapper;

import com.yc.snacks.domain.UserGroup;

import java.util.List;

/**
 * UserGroupMapper继承基类
 */
public interface UserGroupMapper extends MyBatisBaseDao<UserGroup, Integer> {

    List<UserGroup> selectAll();
}