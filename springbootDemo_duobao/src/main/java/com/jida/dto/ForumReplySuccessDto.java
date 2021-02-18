package com.jida.dto;

import lombok.Data;

@Data
public class ForumReplySuccessDto {
    private Long postID;
    private Integer postPageNum;
    private Integer postPageSize;
}
