package com.jida.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jida.dto.ForumReplyDto;
import com.jida.dto.GoodDetailEquipmentDto;
import com.jida.entity.ForumReply;
import com.jida.entity.GoodDetailEquipment;
import com.jida.entity.UserGood;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserGoodMappper extends BaseMapper<UserGood> {
    GoodDetailEquipmentDto  getDetailEquipment(@Param("goodID") Integer goodID);
}
