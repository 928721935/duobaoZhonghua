package com.jida.dto;

import lombok.Data;

import java.util.List;

@Data
public class ForumPostDetailDto {
    private ForumPostDto postData;
    private List<ForumReplyDto> replyList;
    private Integer count;
    private Integer currPage;
    private Integer totalPage;
    private Integer postPageNum;
    private Integer postPageSize;
}
