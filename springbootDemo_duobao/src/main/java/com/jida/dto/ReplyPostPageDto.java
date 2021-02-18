package com.jida.dto;

import lombok.Data;

@Data
public class ReplyPostPageDto {
    private Long postID;
    private Integer postPageNum;
    private Integer postPageSize;
    private Integer replyPageNum;
    private Integer replyPageSize;
}
