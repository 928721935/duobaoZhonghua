package com.jida.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ForumReply {
    private Long id;
    private Long postID;
    private Long replyerID;
    private String msg;
    private Date createTime;
}
