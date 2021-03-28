package com.yc.snacks.service;

import com.yc.snacks.dto.GroupInfoDTO;

import java.util.List;

public interface GroupInfoService {

    List<GroupInfoDTO> getGroupInfoList() throws Exception;
}
