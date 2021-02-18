package com.jida.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jida.dto.ForumReplyDto;
import com.jida.entity.ForumReply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ForumReplyMappper extends BaseMapper<ForumReply> {
    List<ForumReplyDto> getReplyListByPostID(@Param("postID") Long postID,@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);

    Integer getReplyListCountByPostID(@Param("postID") Long postID);
}
