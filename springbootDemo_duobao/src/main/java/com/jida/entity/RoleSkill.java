package com.jida.entity;

import lombok.Data;

@Data
public class RoleSkill {
    private Integer skillID;
    private Long userID;
    private Integer level;
    private Integer studyPercent;
//    private Integer inUsed;
}
