package com.yc.snacks.service.impl;

import com.yc.snacks.domain.UserGroup;
import com.yc.snacks.domain.WorkplacePosition;
import com.yc.snacks.dto.GroupInfoDTO;
import com.yc.snacks.mapper.UserGroupMapper;
import com.yc.snacks.mapper.WorkplacePositionMapper;
import com.yc.snacks.service.GroupInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GroupInfoServiceImpl implements GroupInfoService {

    @Autowired
    private UserGroupMapper userGroupMapper;

    @Autowired
    private WorkplacePositionMapper workplacePositionMapper;

    @Override
    public List<GroupInfoDTO> getGroupInfoList() throws Exception {
        List<GroupInfoDTO> groupInfoDTOList = new ArrayList<>();
        List<UserGroup> userGroupList = userGroupMapper.selectAll();
        if(!ObjectUtils.isEmpty(userGroupList)){
            List<Integer> positionIdList = userGroupList.stream().map(UserGroup::getPositionId).collect(Collectors.toList());
            List<WorkplacePosition> workplacePositionList = workplacePositionMapper.selectByIdList(positionIdList);
            if(!ObjectUtils.isEmpty(workplacePositionList)){
                Map<Integer, String> nameMap = workplacePositionList.stream().collect(Collectors.toMap(WorkplacePosition::getId, WorkplacePosition::getName));
                for(UserGroup userGroup : userGroupList){
                    GroupInfoDTO dto = new GroupInfoDTO(userGroup.getId(), nameMap.get(userGroup.getId()), userGroup.getName());
                    groupInfoDTOList.add(dto);
                }
            }
        }
        return groupInfoDTOList;
    }
}
