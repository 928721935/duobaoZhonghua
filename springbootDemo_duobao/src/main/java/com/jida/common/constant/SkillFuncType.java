package com.jida.common.constant;

public enum SkillFuncType {
    //刀法
    SKILL_FUNCTYPE_DAO(1),
    //拳法
    SKILL_FUNCTYPE_QUAN(2),
    //剑法
    SKILL_FUNCTYPE_JIAN(3),
    //招架
    SKILL_FUNCTYPE_ZHAOJIA(4),
    //轻功
    SKILL_FUNCTYPE_QINGGONG(5),
    //内功
    SKILL_FUNCTYPE_NEIGONG(6),
    ;
    private int type;
    SkillFuncType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
