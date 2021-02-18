package com.jida.dto;

import lombok.Data;

import java.util.List;

@Data
public class RoleSkillDto {
    private Integer skillID;
    private String skillName;
    private Long userID;
    private Integer level;
    private Integer studyPercent;
    private int inUsed;
    private int alreadyBind;
    //是否特殊武功（可配置）
    private int specialSkill;

    //是否是花钱才能用的特殊武功
    private int vipSpecialSkill;

    //作为配置武功的门派类型
    private Integer skillMenPaiType;

    //当是特殊武功时，可作为配置武功的功能类型
    private List<Integer> skillFuncTypeList;

    //当是基本武功时，可作为配置武功的功能类型
    private Integer skillFuncType;
}
