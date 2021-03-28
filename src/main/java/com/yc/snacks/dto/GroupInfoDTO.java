package com.yc.snacks.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupInfoDTO {

    private Integer groupId;

    private String positionName;

    private String groupName;

}
