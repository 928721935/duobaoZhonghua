package com.jida.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jida.dto.ForumPostDto;
import com.jida.entity.ForumPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ForumPostMapper extends BaseMapper<ForumPost> {
    List<ForumPostDto> getForumPostList(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);

    List<ForumPostDto> getTopForumPostList();

    Integer getForumPostListCount();

    ForumPostDto getForumPostByPostID(@Param("postID") Long postID);
}
