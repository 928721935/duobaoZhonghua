package com.jida.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ForumReplyDto {
    private Long id;
    private Long postID;
    private Long replyerID;
    private String replyerPeopleName;
    private String msg;
    private Date createTime;
}
