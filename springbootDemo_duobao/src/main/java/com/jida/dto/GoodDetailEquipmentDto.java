package com.jida.dto;

import lombok.Data;

@Data
public class GoodDetailEquipmentDto {
    private Long id;
    private String goodName;
    private String description;
    private Integer funcType;
    private Integer gong;
    private Integer fang;
    private Integer shan;
    private Integer mingZhong;
    private Integer maxNaiJiu;
    private Integer currNaiJiu;
    private Integer growValue;
    private Integer basicGrowValue;
    private Integer level;
    private Integer maxLevel;
    private Long currExperience;
    private Long maxExperience;
    private Integer isGrow;
    private Integer canDamage;
    private Integer canDrop;
    private Integer canDiscard;
    private Integer canSell;
    private Integer canGive;
}
