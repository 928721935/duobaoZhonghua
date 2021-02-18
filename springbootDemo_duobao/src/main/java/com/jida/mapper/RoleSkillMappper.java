package com.jida.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jida.dto.RoleSkillDto;
import com.jida.entity.RoleSkill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleSkillMappper extends BaseMapper<RoleSkill> {
    List<RoleSkillDto> getSkillList(@Param("userId") Long userId);
}
