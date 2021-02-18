package com.jida.common.constant;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

public enum  SkillEnum {
    TIAN_XIE_SHEN_ZHANG("天邪神掌",1,1,StaticEnum.SKILL_MENPAI_TYPE_MOJIAO, Lists.newArrayList(StaticEnum.SKILL_FUNCTYPE_QUAN,StaticEnum.SKILL_FUNCTYPE_ZHAOJIA),null,0),
    DA_JING_GANG_QUAN("大金刚拳",2,1,StaticEnum.SKILL_MENPAI_TYPE_SHAOLIN,Lists.newArrayList(StaticEnum.SKILL_FUNCTYPE_QUAN,StaticEnum.SKILL_FUNCTYPE_ZHAOJIA),null,0),
    ROU_HONG_ZHI("柔虹指",3,1,StaticEnum.SKILL_MENPAI_TYPE_SHAOLIN,Lists.newArrayList(StaticEnum.SKILL_FUNCTYPE_QUAN,StaticEnum.SKILL_FUNCTYPE_ZHAOJIA),null,0),

    I_BAO_TIAN_LANG_WU("七宝天岚舞",4,1,StaticEnum.SKILL_MENPAI_TYPE_MOJIAO, Lists.newArrayList(StaticEnum.SKILL_FUNCTYPE_QINGGONG),null,0),
    SHAO_LIN_SHEN_FA("少林身法",5,1,StaticEnum.SKILL_MENPAI_TYPE_SHAOLIN,Lists.newArrayList(StaticEnum.SKILL_FUNCTYPE_QINGGONG),null,0),
    QIU_FENG_BU_FA("秋风步法",6,1,StaticEnum.SKILL_MENPAI_TYPE_SHAOLIN,Lists.newArrayList(StaticEnum.SKILL_FUNCTYPE_QINGGONG),null,0),

    chun_feng_kuai_yi_dao("春风快意刀",7,1,StaticEnum.SKILL_MENPAI_TYPE_MOJIAO, Lists.newArrayList(StaticEnum.SKILL_FUNCTYPE_DAO,StaticEnum.SKILL_FUNCTYPE_ZHAOJIA),null,0),
    DA_MO_JIAN("达摩剑",8,1,StaticEnum.SKILL_MENPAI_TYPE_SHAOLIN,Lists.newArrayList(StaticEnum.SKILL_FUNCTYPE_JIAN,StaticEnum.SKILL_FUNCTYPE_ZHAOJIA),null,0),
    HUI_FENG_GU_LIU_JIAN("回风拂柳剑",9,1,StaticEnum.SKILL_MENPAI_TYPE_SHAOLIN,Lists.newArrayList(StaticEnum.SKILL_FUNCTYPE_JIAN,StaticEnum.SKILL_FUNCTYPE_ZHAOJIA),null,0),

    TIAN_HUAN_SHEN_JUE("天寰神诀",10,1,StaticEnum.SKILL_MENPAI_TYPE_MOJIAO, Lists.newArrayList(StaticEnum.SKILL_FUNCTYPE_NEIGONG),null,0),
    HUN_YUAN_YI_QI_GONG("混元一气功",11,1,StaticEnum.SKILL_MENPAI_TYPE_SHAOLIN,Lists.newArrayList(StaticEnum.SKILL_FUNCTYPE_NEIGONG),null,0),
    ZHEN_YUE_JUE("震岳诀",12,1,StaticEnum.SKILL_MENPAI_TYPE_SHAOLIN,Lists.newArrayList(StaticEnum.SKILL_FUNCTYPE_NEIGONG),null,0),

    JI_BEN_QUAN_JIAO("基本拳脚",13,0,StaticEnum.SKILL_MENPAI_TYPE_NONE,null,StaticEnum.SKILL_FUNCTYPE_QUAN,0),
    JI_BEN_DAO_FA("基本刀法",14,0,StaticEnum.SKILL_MENPAI_TYPE_NONE,null,StaticEnum.SKILL_FUNCTYPE_DAO,0),
    JI_BEN_JIAN_FA("基本剑法",15,0,StaticEnum.SKILL_MENPAI_TYPE_NONE,null,StaticEnum.SKILL_FUNCTYPE_JIAN,0),
    JI_BEN_ZHAO_JIA("基本招架",16,0,StaticEnum.SKILL_MENPAI_TYPE_NONE,null,StaticEnum.SKILL_FUNCTYPE_ZHAOJIA,0),
    JI_BEN_QING_GONG("基本轻功",17,0,StaticEnum.SKILL_MENPAI_TYPE_NONE,null,StaticEnum.SKILL_FUNCTYPE_QINGGONG,0),
    JI_BEN_NEI_GONG("基本内功",18,0,StaticEnum.SKILL_MENPAI_TYPE_NONE,null,StaticEnum.SKILL_FUNCTYPE_NEIGONG,0),

    XIANG_LONG_SHI_BA_ZHANG("降龙十八掌",19,1,StaticEnum.SKILL_MENPAI_TYPE_NONE,Lists.newArrayList(StaticEnum.SKILL_FUNCTYPE_QUAN,StaticEnum.SKILL_FUNCTYPE_ZHAOJIA),null,1),
    BI_XIE_JIAN_FA("辟邪剑法",20,1,StaticEnum.SKILL_MENPAI_TYPE_NONE,Lists.newArrayList(StaticEnum.SKILL_FUNCTYPE_JIAN,StaticEnum.SKILL_FUNCTYPE_ZHAOJIA,StaticEnum.SKILL_FUNCTYPE_QINGGONG),null,1),
    ;

    private String name;

    private Integer skillID;

    //是否特殊武功（可配置）
    private int specialSkill;

    public int getVipSpecialSkill() {
        return vipSpecialSkill;
    }

    //是否是花钱才能用的特殊武功
    private int vipSpecialSkill;

    //作为配置武功的门派类型
    private Integer skillMenPaiType;

    //当是特殊武功时，可作为配置武功的功能类型
    private List<Integer> skillFuncTypeList;

    //当是基本武功时，可作为配置武功的功能类型
    private Integer skillFuncType;

    private SkillEnum(String name, Integer skillID, int specialSkill, Integer skillMenPaiType, List<Integer> skillFuncTypeList, Integer skillFuncType,int vipSpecialSkill) {
        this.name = name;
        this.skillID = skillID;
        this.specialSkill = specialSkill;
        this.skillMenPaiType = skillMenPaiType;
        this.skillFuncTypeList = skillFuncTypeList;
        this.skillFuncType = skillFuncType;
        this.vipSpecialSkill = vipSpecialSkill;
    }

    public String getName() {
        return name;
    }

    public Integer getSkillID() {
        return skillID;
    }

    public int getSpecialSkill() {
        return specialSkill;
    }

    public Integer getSkillMenPaiType() {
        return skillMenPaiType;
    }

    public List<Integer> getSkillFuncTypeList() {
        return skillFuncTypeList;
    }

    public Integer getSkillFuncType() {
        return skillFuncType;
    }

    private static Map<Integer,SkillEnum> id_skillMap = Arrays.stream(SkillEnum.values()).collect(Collectors.toMap(SkillEnum::getSkillID, v -> v, (v1, v2) -> v1));
    private static Map<Integer,List<SkillEnum>> funcType_SpecSkillListMap = new HashMap<>();
    static {
        for (SkillEnum skillEnum:SkillEnum.values()) {
            if(skillEnum.getSpecialSkill()==1){
                List<Integer> skillFuncTypeList = skillEnum.getSkillFuncTypeList();
                for (Integer skillFuncType:skillFuncTypeList) {
                    List<SkillEnum> skillEnums = funcType_SpecSkillListMap.get(skillFuncType);
                    if(skillEnums == null){
                        skillEnums = new ArrayList<>();
                        funcType_SpecSkillListMap.put(skillFuncType,skillEnums);
                    }
                    skillEnums.add(skillEnum);
                }
            }
        }
    }
    public static SkillEnum getSkillById(Integer skillID){
        return id_skillMap.get(skillID);
    }
    public static List<SkillEnum> getSkillByFuncType(Integer funcType){
        return funcType_SpecSkillListMap.get(funcType);
    }
}
