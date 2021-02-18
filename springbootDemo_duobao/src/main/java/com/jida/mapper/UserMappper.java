package com.jida.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jida.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMappper extends BaseMapper<User> {

}
